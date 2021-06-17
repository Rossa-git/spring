package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;
import com.simple.dao.BoardDAO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	@Qualifier("boardDAO")
	private BoardDAO dao;
	
	@Override
	public void boardRegist(BoardVO vo) {
		dao.boardRegist(vo);
	}

	@Override
	public ArrayList<BoardVO> getList() {
		
		ArrayList<BoardVO> list = dao.getList();
		
		return list;
	}

	@Override
	public void boardDelete(int num) {
		dao.boardDelete(num);
	}

}
