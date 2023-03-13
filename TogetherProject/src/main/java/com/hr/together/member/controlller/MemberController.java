package com.hr.together.member.controlller;

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
public class MemberController {


	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	private MemberService memberService;
	
	// 기본생성자
	public MemberController() {
		
	}

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value = "member/loginForm", method = {RequestMethod.GET })
	public String login(Model model, HttpSession session) {

		logger.info(">> 로그인 폼으로 이동");

		return "member/loginForm";
	}
	
	
	
}
