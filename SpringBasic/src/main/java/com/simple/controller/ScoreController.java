package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.command.ScoreVO;
import com.simple.service.ScoreService;
import com.simple.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ScoreController {

	//멤버변수
	//첫번째 방법 : 고전적인 방법
	//private ScoreService scoreService = new ScoreServiceImpl();
	
	
	//두번째 방법 : bean으로 선언, 의존객체 자동 주입하기
//	@Autowired
//	@Qualifier("scoreService")
//	private ScoreService scoreService;
	
	
	//세번째 방법
	@Autowired
	@Qualifier("scoreService")
	private ScoreService scoreService;
	
	
	//목록화면(화면으로 이동할 때 list를 가지고 나간다)
	@RequestMapping("/scoreList")
	public void scoreList(Model model) {
		
		//화면에서는 list이름으로 데이터를 처리
//		ArrayList<ScoreVO> list = scoreService.getList();	
		model.addAttribute("list",scoreService.getList());
		
	}
	
	//등록화면
	@RequestMapping("/scoreRegist")
	public void scoreRegist() {
		
	}
	
	//결과화면
	@RequestMapping("/scoreResult")
	public void scoreResult() {
		
	}
	
	//등록요청
	@RequestMapping("/regist")
	public String regist(ScoreVO vo) {
		
		scoreService.regist(vo);
		
		return "service/scoreResult";
	}
	
}
