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
	 * ��ʼҳ��
	 */
	public String index() {

		return SUCCESS;
	}

	/*
	 * ��¼
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
			result.setMessage("�˺Ż����벻ƥ��");
		}
		return SUCCESS;
	}

	/*
	 * ע��
	 */
	public String regist() {
		result = new reslutMessage();
		User user = new User();
		user.setEmail(u.getEmail());
		List<User> list = us.select(user);
		if (list.size() != 0) {
			result.setMessage("�˺��Ѵ���");
		} else {
			result.setOrsucess(true);
			u.setPassword(MD5Util.MD5EncodeUtf8(u.getPassword()));
			us.update(u);
		}
		return SUCCESS;
	}

	/*
	 * ��������ҳ��
	 */
	public String forget_pwd() {
		return SUCCESS;
	}

	/*
	 * ������֤��
	 */
	public String sendmail() throws Exception {
		result = new reslutMessage();
		List<User> li = us.select(u);
		String verificationCode;
		if (li.size() == 0)
			result.setMessage("��֤�뷢��ʧ��,�˺Ų�����");
		else
			result.setMessage("��֤���ѷ��͵����䣬��ע�����");

		verificationCode = Verification.verification();
		ActionContext.getContext().getSession().put("verificationCode", verificationCode);
		ActionContext.getContext().getSession().put("email", u.getEmail());
		MailUtil.send(u.getEmail(), "���������֤", "�����ڽ��и����������,��Ǳ��˲���,����Ա���Ϣ.��֤��:" + verificationCode
				+ ".<p><a href='http://192.168.6.250:8080/video-web/user/forget_pwd.action'>��������</a></P>");
		return SUCCESS;
	}
	/*
	 * ��֤����֤
	 */
	public String forgetpwd() {
		result = new reslutMessage();
		String verificationCode=(String) ActionContext.getContext().getSession().get("verificationCode");
		if (verificationCode.equals(u.getCaptcha())) {
			result.setOrsucess(true);
			ActionContext.getContext().getSession().remove("verificationCode");
		} else
			result.setMessage("��֤�����!");
		return SUCCESS;
	}
	/*
	 * ��������ҳ��
	 */
	public String reset_pwd() {
		return SUCCESS;
	}
	/*
	 * ��������
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
