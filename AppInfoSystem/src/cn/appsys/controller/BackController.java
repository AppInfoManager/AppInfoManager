package cn.appsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class BackController {

	@RequestMapping("/login")
	public String login() {
		
		
		return "backendlogin";
	}
	
}
