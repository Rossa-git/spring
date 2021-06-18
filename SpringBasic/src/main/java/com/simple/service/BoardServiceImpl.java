package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.BoardVO;
import com.simple.dao.BoardDAO;
import com.simple.mapper.BoardMapper;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	//1. DAO 연결
//	@Autowired
//	@Qualifier("boardDAO")
//	private BoardDAO dao;
	
	//2. Mapper 연결
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public void boardRegist(BoardVO vo) {
//		dao.boardRegist(vo);

		boardMapper.boardRegist(vo);
	}

	@Override
	public ArrayList<BoardVO> getList() {
//		return dao.getList();
		
		return boardMapper.getList();
	}

	@Override
	public void boardDelete(int num) {
//		dao.boardDelete(num);
		
		boardMapper.boardDelete(num);
	}

}
