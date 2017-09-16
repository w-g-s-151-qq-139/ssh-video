package com.zhiyou100.web.action;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhiyou100.dao.model.User;
import com.zhiyou100.dao.utils.MD5Util;
import com.zhiyou100.dao.utils.MulFileUtil;
import com.zhiyou100.dao.utils.reslutMessage;
import com.zhiyou100.service.user.UserService;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {

	@Autowired
	UserService us;

	private reslutMessage result;
	private User user = new User();
	private String birthday1;
	private String newPassword;
	private String oldPassword;
	
	private File image_file;
	private String image_fileFileName;
	private String image_fileContentType;


	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public reslutMessage getResult() {
		return result;
	}

	public File getImage_file() {
		return image_file;
	}

	public void setImage_file(File image_file) {
		this.image_file = image_file;
	}

	public String getImage_fileFileName() {
		return image_fileFileName;
	}

	public void setImage_fileFileName(String image_fileFileName) {
		this.image_fileFileName = image_fileFileName;
	}

	public String getImage_fileContentType() {
		return image_fileContentType;
	}

	public void setImage_fileContentType(String image_fileContentType) {
		this.image_fileContentType = image_fileContentType;
	}

	public String getBirthday1() {
		return birthday1;
	}

	public void setBirthday1(String birthday1) {
		this.birthday1 = birthday1;
	}

	/*
	 * 详细资料
	 */
	public String userdata() {
		ActionContext context = ActionContext.getContext();
		User u = (User) context.getSession().get("_front_user");
		u.setPassword(null);
		u = us.select(u).get(0);
		context.getSession().put("_front_user", u);
		context.put("user", u);
		return SUCCESS;
	}

	/*
	 * 退出
	 */
	public String logout() {
		ActionContext.getContext().getSession().remove("_front_user");
		return SUCCESS;
	}

	/*
	 * 更改资料界面
	 */
	public String profile() {
		ActionContext context = ActionContext.getContext();
		User u = (User) context.getSession().get("_front_user");
		List<User> ul = us.select(u);

		context.put("user", u);
		return SUCCESS;
	}

	/*
	 * 保存资料
	 */
	public String keepprofile() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(birthday1);
		User u = (User) ActionContext.getContext().getSession().get("_front_user");
		u.setBirthday(date);
		u.setNickName(user.getNickName());
		u.setSex(user.getSex());
		u.setProvince(user.getProvince());
		u.setCity(user.getCity());
		us.update(u);
		return SUCCESS;
	}

	/*
	 * 修改头像界面
	 */
	public String avatar() {
		return SUCCESS;
	}

	/*
	 * 保存头像
	 */
	public String altavatar() throws IOException {
		User u = (User) ActionContext.getContext().getSession().get("_front_user");
		u.setHeadUrl(MulFileUtil.filename(image_fileFileName));
		us.update(u);
		FileUtils.copyFile(image_file, MulFileUtil.file(u.getHeadUrl()));
		return SUCCESS;
	}

	/*
	 * 更改密码界面
	 */
	public String password() {

		return SUCCESS;
	}
	/*
	 * 保存密码更改
	 */
	public String altpassword(){
		result=new reslutMessage();
		User u = (User) ActionContext.getContext().getSession().get("_front_user");
		oldPassword=MD5Util.MD5EncodeUtf8(oldPassword);
		if(oldPassword.equals(u.getPassword())){
			u.setPassword(MD5Util.MD5EncodeUtf8(newPassword));
			us.update(u);
			result.setOrsucess(true);
		}else{
			result.setMessage("密码错误!无法更改密码");
		}
		return SUCCESS;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
