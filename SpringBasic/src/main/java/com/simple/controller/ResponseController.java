package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {

	
	// res_ex01 화면처리
	@RequestMapping("/res_ex01")
	public void res_ex01() {
		
	}

	
	//Model전달자
	@RequestMapping("/res_ex02")
	public String res_ex02(Model model) {
		//ModelMap에 실어도된다
		
		model.addAttribute("servertime", new Date());
		model.addAttribute("name", "홍길동");
		
		return "response/res_ex02";
	}
	
	
	//ModelAndView방법 - 데이터 addObject(키, 값), 화면정보 setViewName()
	@RequestMapping("/res_ex03")
	public ModelAndView res_ex03() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("servertime", new Date());
		mv.setViewName("response/res_ex03"); //이동될 페이지 명
		
		return mv; //디스패처서블릿으로 반환
	}
	
	
	//@ModelAttribute전달자 - @RequestParam + Model
	@RequestMapping("/res_ex04")
	public String res_ex04(@ModelAttribute("id") String id) {
		
		System.out.println("넘어온값: "+ id);
		
		return "response/res_ex04";
	}
	
	
	//@ModelAttribute 값이 여러개일때
	@RequestMapping("/res_ex05")
	public String res_ex05(@ModelAttribute("info") ReqVO vo) {
		
		System.out.println("넘어온값:" + vo.toString());
		
		return "response/res_ex05";
	}
	
	
	
	//----------------- 리다이렉트와 리다이렉트 어트리뷰트
	//화면처리
	@RequestMapping("/res_redirect")
	public void res_redirect() {
		
	}
	
	//가정 - 아이디 비밀번호가 동일하면 성공화면, 다르다면 다시 로그인화면으로 이동
	@RequestMapping("/login")
	public String login(ReqVO vo,
						RedirectAttributes ra) {
		
		if(vo.getId().equals(vo.getPw())) { //아이디 비밀번호가 동일할 때
			
			return "response/res_login_ok";
		} else { //동일하지 않을 때
			
			//이때 화면에 1회성 데이터로 값을 전달하고 싶다면
			//RedirectAttributes의 addFlashAttribute를 이용
			ra.addFlashAttribute("msg", "아이디 비밀번호를 확인하세요");
			
			
			// [ redirect:/절대경로 ]  로 보내면 컨트롤러에게 다시 요청
			return "redirect:/response/res_redirect"; //다시 로그인화면으로			
		}
		
	}
	
	
	//-----------req_quiz01
	@RequestMapping("/res_quiz01")
	public void res_quiz01() {
		
	}
	
	
//	@RequestMapping("res_login")
//	public String res_login(@ModelAttribute("id") String id,
//							@ModelAttribute("pw") String pw) {
//		
//		
//		if(id.equals("kim12") && pw.equals("1234")) {
//			return "response/res_quiz02";
//		} else {
//			return "response/res_quiz03";
//		}	
//	}
	
	@RequestMapping("res_login")
	public ModelAndView res_login(@ModelAttribute("id") String id,
								@ModelAttribute("pw") String pw) {
		
		//ModelAndView 사용할 경우
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		
		if(id.equals("kim12") && pw.equals("1234")) {
			mv.setViewName("response/res_quiz02");
		} else {
			mv.setViewName("response/res_quiz03");
		}
		
		return mv;
	}
}
