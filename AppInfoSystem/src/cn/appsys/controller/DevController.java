package cn.appsys.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.DevUserService;


@Controller
@RequestMapping("/dev")
public class DevController {
	
	private final static String CURUSER = "CURRENTUSER";
	
	private static Logger log = Logger.getLogger(DevController.class);
	@Autowired
	private DevUserService devUserService;
	
	
	public DevUserService getDevUserService() {
		return devUserService;
	}
	public void setDevUserService(DevUserService devUserService) {
		this.devUserService = devUserService;
	}
	@RequestMapping("/login")
	public String login() {
		
		
		return "devlogin";
	}
	@RequestMapping("/dologin")
	public String doLogin(DevUser devUser,HttpSession session) {
		
		log.info(devUser.getDevCode()+"=======");
		
		devUser = devUserService.appDologin(devUser);
		if(devUser != null) {
			//���û���Ϣ����session
			session.setAttribute(DevController.CURUSER, devUser);
			return "redirect:/dev/flatform/main";
		}
		return "devlogin";
		
		
	}
	@RequestMapping("/flatform/main")	
	public String flatformMain(HttpSession session) {
		//У���û��Ƿ��¼
		Object object = session.getAttribute(DevController.CURUSER);
		if(object == null)
			//�û�û�е�¼  �ض���ص�¼ҳ
			return "login";
		//·����Ҫ�ο���ͼ��������ǰ׺�ͺ�׺
		return "developer/main";
	}
	@RequestMapping("/flatform/app/list")
	public String flatFormApplist() {
		
		
		
		return "developer/appinfolist";
	}
}
