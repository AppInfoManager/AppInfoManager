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
			//将用户信息放入session
			session.setAttribute(DevController.CURUSER, devUser);
			return "redirect:/dev/flatform/main";
		}
		return "devlogin";
		
		
	}
	@RequestMapping("/flatform/main")	
	public String flatformMain(HttpSession session) {
		//校验用户是否登录
		Object object = session.getAttribute(DevController.CURUSER);
		if(object == null)
			//用户没有登录  重定向回登录页
			return "login";
		//路径需要参考试图解析器的前缀和后缀
		return "developer/main";
	}
	@RequestMapping("/flatform/app/list")
	public String flatFormApplist() {
		
		
		
		return "developer/appinfolist";
	}
}
