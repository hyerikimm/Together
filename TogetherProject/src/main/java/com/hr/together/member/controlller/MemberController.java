package com.hr.together.member.controlller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
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
	
	@RequestMapping(value="/member/login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session, Member member, Model model) throws Exception {
		try {
			//로그아웃시 파라미터 없이 접근하며 이하 구문 실행됨
			session.removeAttribute("LoginVO");
			//모든 쿠키 제거(path가 일치하지 않는 항목은 삭제되지 않음에 유의)
			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				for(int i=0; i < cookies.length; i++){
					//System.out.println("[Name(" + i + ")]" + cookies[i].getName() + ", path:" + cookies[i].getPath() + ", domain:" + cookies[i].getDomain());
					// 쿠키의 유효시간을 0으로 설정하여 바로 만료시킨다.
					cookies[i].setMaxAge(0);
					cookies[i].setPath("/");
					// 응답에 쿠키 추가
					response.addCookie(cookies[i]);
				}
			}
			model.addAttribute("member", member);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return "/member/loginForm";
	}
	
	@RequestMapping(value = "/member/join.do", method = {RequestMethod.GET })
	public String joinMember(Model model, HttpSession session) throws Exception {

		return "/member/joinForm";
	}
	
	@RequestMapping(value = "/member/loginProcess.do", method = {RequestMethod.POST })
	public String loginProcess(Model model, HttpSession session, Member member) throws Exception {
		//member.setUserPwd(CommonUtil.encryptSHA256(member.getUserPwd()));
		member.setUserPwd(member.getUserPwd());
		logger.debug("memberVO.getUserPwd()=>" + member.getUserPwd());
		Member resultVO = memberService.selectMemberViewByLogin(member);
		
		if(resultVO != null ){
			session.setAttribute("LoginVO", resultVO);
		}else{
			model.addAttribute("PARAM_URL", "/member/loginForm");
			model.addAttribute("alertMsg", "로그인 정보가 올바르지 않거나 가입된 회원이 아닙니다.");

			//return "/cmm/alertMessage";
			return "redirect:/";
		}
		return "redirect:/";
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
