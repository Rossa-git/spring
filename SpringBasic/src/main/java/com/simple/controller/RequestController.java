package com.simple.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/request") //클래스의 requestMapping은 메서드의 요청경로를 묶어서 사용
public class RequestController {

//	@RequestMapping("/req_ex01")
//	public String req_ex01() {
//		System.out.println("실행됨");
//		return "request/req_ex01";
//	}
	
	//void 메서드는 들어오는 경로 자체가 viewresolver로 들어가게 된다.
	@RequestMapping("/req_ex01")
	public void req_ex01() { 
		
	}
	
//	//basic01요청
//	@RequestMapping(value="/basic01", method=RequestMethod.GET)
//	public void basic01() {
//		System.out.println("basic01실행");
//	}
//	
//	
//	//basic02
//	@RequestMapping(value="/basic02", method=RequestMethod.POST)
//	public void basic02() {
//		System.out.println("basic02실행");
//	}
//	
//	
//	//basic03
//	@RequestMapping(value="/basic03")
//	public void basic03() {
//		System.out.println("basic03실행");
//	}
	
	
	//basic01, 02, 03을 하나의 메서드로 받아서 처리하는 법
	//반드시 void형으로 선언할 것
	@RequestMapping({"/basic01","/basic02","/basic03"})
	public void basic() {
		System.out.println("basic 1,2,3");
	}
	
	
	
	//------------------------요청파라미터값 받기(req_ex02.jsp)-----------
	@RequestMapping("/req_ex02")
	public String req_ex02() {
		
		return "request/req_ex02";
	}
	
	//param 요청 처리.
	//1. HttpServletRequest request 객체 이용하기 
//	@RequestMapping("/param")
//	public String param(HttpServletRequest request) {
//		
//		System.out.println(request.getParameter("id"));
//		System.out.println(Arrays.toString(request.getParameterValues("inter")));
//		
//		return "request/req_ex02_result";
//	}
	
	
	//2. 어노테이션 이용하기
	/*
	 * 어노테이션 추가 속성
	 * 1) required - 해당 파라미터가 필수가 아닌 경우 false(기본값 true)
	 * 2) defaultValue - required 지정(false)시 기본값 
	 */
	@RequestMapping("/param")
	public String param(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("name") String name,
			@RequestParam(value = "inter", required = false, defaultValue = "") ArrayList<String> inter
			) {
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(inter.toString());
		
		return "request/req_ex02_result";
	}
}
