package com.zhiyou100.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.dao.model.User;
import com.zhiyou100.dao.utils.MD5Util;
import com.zhiyou100.dao.utils.MailUtil;
import com.zhiyou100.dao.utils.Verification;
import com.zhiyou100.dao.utils.reslutMessage;
import com.zhiyou100.service.user.UserService;

@Controller
@Scope("prototype")
public class VisitorAction extends ActionSupport implements ModelDriven<User> {

	@Autowired
	UserService us;

	private reslutMessage result;
	private User u = new User();

	public reslutMessage getResult() {
		return result;
	}

	/*
	 * 初始页面
	 */
	public String index() {

		return SUCCESS;
	}

	/*
	 * 登录
	 */
	public String login() {
		result = new reslutMessage();
		u.setPassword(MD5Util.MD5EncodeUtf8(u.getPassword()));
		List<User> ul = us.select(u);
		if (ul.size() != 0) {
			ActionContext.getContext().getSession().put("_front_user", ul.get(0));
			result.setOrsucess(true);
		} else {
			result.setOrsucess(false);
			result.setMessage("账号或密码不匹配");
		}
		return SUCCESS;
	}

	/*
	 * 注册
	 */
	public String regist() {
		result = new reslutMessage();
		User user = new User();
		user.setEmail(u.getEmail());
		List<User> list = us.select(user);
		if (list.size() != 0) {
			result.setMessage("账号已存在");
		} else {
			result.setOrsucess(true);
			u.setPassword(MD5Util.MD5EncodeUtf8(u.getPassword()));
			us.update(u);
		}
		return SUCCESS;
	}

	/*
	 * 忘记密码页面
	 */
	public String forget_pwd() {
		return SUCCESS;
	}

	/*
	 * 发送验证码
	 */
	public String sendmail() throws Exception {
		result = new reslutMessage();
		List<User> li = us.select(u);
		String verificationCode;
		if (li.size() == 0)
			result.setMessage("验证码发送失败,账号不存在");
		else
			result.setMessage("验证码已发送到邮箱，请注意查收");

		verificationCode = Verification.verification();
		ActionContext.getContext().getSession().put("verificationCode", verificationCode);
		ActionContext.getContext().getSession().put("email", u.getEmail());
		MailUtil.send(u.getEmail(), "密码更改验证", "您正在进行更改密码操作,如非本人操作,请忽略本消息.验证码:" + verificationCode
				+ ".<p><a href='http://192.168.6.250:8080/video-web/user/forget_pwd.action'>重置密码</a></P>");
		return SUCCESS;
	}
	/*
	 * 验证码验证
	 */
	public String forgetpwd() {
		result = new reslutMessage();
		String verificationCode=(String) ActionContext.getContext().getSession().get("verificationCode");
		if (verificationCode.equals(u.getCaptcha())) {
			result.setOrsucess(true);
			ActionContext.getContext().getSession().remove("verificationCode");
		} else
			result.setMessage("验证码错误!");
		return SUCCESS;
	}
	/*
	 * 重置密码页面
	 */
	public String reset_pwd() {
		return SUCCESS;
	}
	/*
	 * 重置密码
	 */
	public String resetpwd() {
		String pwd=u.getPassword();
		u.setPassword(null);
		List<User> list = us.select(u);
		u=list.get(0);
		u.setPassword(MD5Util.MD5EncodeUtf8(pwd));
		us.update(u);
		ActionContext.getContext().getSession().put("_front_user", u);
		return SUCCESS;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return u;
	}
}
