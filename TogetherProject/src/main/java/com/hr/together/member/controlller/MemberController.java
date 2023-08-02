package com.hr.together.member.controlller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hr.together.member.model.service.KakaoAPI;
import com.hr.together.member.model.service.MemberService;
import com.hr.together.member.model.vo.Member;

@Controller
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	private MemberService memberService;
	private KakaoAPI kakao;
	private int count = 0; 
	
	// 기본생성자
	public MemberController() {
		
	}

	@Autowired
	public MemberController(MemberService memberService, KakaoAPI kakao) {
		this.memberService = memberService;
		this.kakao = kakao;
	}
	
	@RequestMapping(value = "member/loginForm", method = {RequestMethod.GET })
	public String login(Model model, HttpSession session) {

		logger.info(">> 로그인 폼으로 이동");
		return "member/loginForm";
	}
	
	@RequestMapping(value = "member/joinForm", method = {RequestMethod.GET })
	public String joinMember(Model model, HttpSession session) {

		logger.info(">> 회원가입 폼으로 이동");
		return "member/joinForm";
	}
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session, Member member) {
		
		String access_Token = (String)session.getAttribute("access_Token");
		
		if(access_Token != null) { //kakao 로그인 했던 경우
			
			Member kakaoMember = kakao.getUserInfo(access_Token);
			kakaoMember = memberService.loginAndMemberEnroll(member);
			
			session.setAttribute("loginUser", member);
			session.setAttribute("access_Token", access_Token);
		}
		
		if(count == 0) {
    		session.setAttribute("alertMsg", member.getUserName()+"님 환영합니다");
    		count++;
    	}
		
		return "home";
	}
	*/
	
	/**
	 * kakao 로그인
	 * 
	 * @param code
	 * @param session
	 * @return
	 */
	/*
	@RequestMapping(value = "/loginJoin/kakao")
	public String login(@RequestParam("code") String code, HttpSession session) {

		// 받은 code로 access_token 가져오기
		String access_Token = kakao.getAccessToken(code);

		// access_token으로 user정보 가져오기 (닉네임, 이메일계정)
		Member member = kakao.getUserInfo(access_Token);
		logger.info("login Controller : " + member.toString());

		// 클라이언트의 이메일이 존재할 때(즉, 카카오 로그인 성공)
		if (member != null) {

			// email과 nickname으로 회원체크, 회원가입/로그인 성공 후 member객체 반환
			member = memberService.loginAndMemberEnroll(member);
			logger.info("member : " + member);

			if (member == null) {
				kakao.unlink(access_Token);
				session.setAttribute("alertMsg", "로그인 및 회원가입을 할 수 없는 유저입니다.");
				return "redirect:/";
			}
			
			String accountInfo =  memberService.userAcountIs(member.getUserNo());
			session.setAttribute("accountInfo", accountInfo);
			
			session.setAttribute("loginUser", member);
			session.setAttribute("access_Token", access_Token);
			session.setAttribute("alertMsg", member.getUserName() + "님 환영합니다");
		}

		return "redirect:/";
	}
*/
	/**
	 * kakao 이 서비스에서만 로그아웃
	 * @param session
	 * @return
	 */
	/*
	@RequestMapping(value = "/logout/kakao")
	public String logout(HttpSession session) throws IOException {
		String access_Token = (String) session.getAttribute("access_Token");
		if (access_Token != null && !"".equals(access_Token)) {
			kakao.kakaoLogout(access_Token);
			session.removeAttribute("access_Token");
			session.removeAttribute("loginUser");
			session.removeAttribute("userId");
			session.removeAttribute("accountInfo");
			session.setAttribute("alertMsg", "다음에 또 오세요 ^ㅁ^");
		} else {
			System.out.println("access_Token is null");
		}
		return "redirect:/";
	}
*/
	/**
	 * kakao 계정과 함께 로그아웃(연결끊기)
	 * @param session
	 * @return
	 */
	/*
	@RequestMapping(value = "/kakaounlink")
	public String unlink(HttpSession session) {
		kakao.unlink((String) session.getAttribute("access_Token"));
		session.invalidate();
		session.removeAttribute("loginUser");
		session.removeAttribute("accountInfo");
		session.setAttribute("alertMsg", "다음에 또 오세요 ^ㅁ^");
		return "redirect:/";
	}
	
	*/
}
