package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {

	
	//------------------quiz01-----------------
	
	@RequestMapping("/quiz01")
	public void quiz01() {
		
	}
	
//	@RequestMapping("/sendBirth")
//	public String sendBirth(@ModelAttribute("birth") Quiz01VO vo) {
//		
//		if(Integer.parseInt(vo.getMonth()) < 10) {
//			vo.setMonth("0"+ vo.getMonth());
//		}
//		if(Integer.parseInt(vo.getDay()) < 10) {
//			vo.setDay("0"+ vo.getDay());
//		}
//		System.out.println(vo.getYear() + vo.getMonth() + vo.getDay());
//	
//		return "quiz/quiz01_ok";
//	}
	
	
	@RequestMapping("/sendBirth")
	public String sendBirth(Quiz01VO vo, Model model) {
		
		String result = vo.getYear() + vo.getMonth() + vo.getDay();
		System.out.println(result);
		
		model.addAttribute("year", vo.getYear());
		model.addAttribute("month", vo.getMonth());
		model.addAttribute("day", vo.getDay());
		
		return "quiz/quiz01_ok";
	}
	
	//------------------quiz02-----------------
	
	@RequestMapping("/quiz02")
	public void quiz02() {
		
	}
	
	@RequestMapping(value="join", method = RequestMethod.POST)
	public String join(@ModelAttribute("id") String id,
						@ModelAttribute("pw") String pw,
						@ModelAttribute("name") String name,
						@ModelAttribute("email") String email) {
		
		return "quiz/quiz02_ok";
	}
	
	
	//------------------quiz03-----------------
	@RequestMapping("/quiz03")
	public void quiz03() {
		
	}
	
	@RequestMapping("/join2")
	public String join2(RedirectAttributes ra, 
						@ModelAttribute("id") String id,
						@ModelAttribute("pw") String pw,
						@ModelAttribute("pw_check") String pw_check) {
		if(id.equals("")) {
			ra.addFlashAttribute("msg", "아이디를 입력하세요");
			return "redirect:/quiz/quiz03";
		} else if(pw.equals("") | !pw.equals(pw_check)) {
			ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
		} else {
			return "quiz/quiz03_ok";
		}
			
	}
}
