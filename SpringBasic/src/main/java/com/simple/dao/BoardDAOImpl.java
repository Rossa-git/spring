package com.simple.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.simple.command.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	//DB로 가정한 arraylist
	private ArrayList<BoardVO> list = new ArrayList<>();
	private int bno = 1;
	
	@Override
	public void boardRegist(BoardVO vo) {
		vo.setBno(bno++);
		list.add(vo);
	}

	@Override
	public ArrayList<BoardVO> getList() {
		return list;
	}

	@Override
	public void boardDelete(int num) {
		list.remove(num);
	}


}
