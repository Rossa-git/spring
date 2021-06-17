package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.BoardVO;
import com.simple.service.BoardService;

@Controller
@RequestMapping("/service")
public class BoardServiceController {

	@Autowired
	@Qualifier("boardService")
	private BoardService boardService;
	
	//게시물 등록 화면
	@RequestMapping("/boardRegister")
	public void boardRegister() {
		
	}
	
	//게시물 등록 요청
	@RequestMapping(value="/boardForm", method=RequestMethod.POST)
	public String boardForm(BoardVO vo) {
		boardService.boardRegist(vo);
		
		return "service/boardResult";
	}
	
	//게시물 등록 완료 화면
	@RequestMapping("/boardResult")
	public void boardResult() {
		
	}
	
	//게시물 목록 화면
	@RequestMapping("/boardList")
	public void boardList(Model model) {
		ArrayList<BoardVO> list = boardService.getList();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("num") int num) {
		boardService.boardDelete(num);
		
		return "redirect:/service/boardList";
	}
}
