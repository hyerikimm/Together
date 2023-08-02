package com.hr.together;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.together.member.model.service.MemberService;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	public static final String HOME = "redirect:/";
	private MemberService memberservice;
	
	public HomeController() {

	}
	
	@Autowired
	public HomeController(MemberService memberservice) {
		this.memberservice = memberservice;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		
		return "home";
	}
	
	@RequestMapping(value = "/errors/error500")
	public String errors500() {
		
		return "/errors/error500";
	}
	
	@RequestMapping(value = "/errors/error405")
	public String errors405() {
		
		return "/errors/error405";
	}
	
	@RequestMapping(value = "/errors/error404")
	public String errors404() {
		
		return "/errors/error404";
	}
	
}
