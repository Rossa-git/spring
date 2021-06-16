package com.simple.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("yyy")
public class ScoreDAOImpl implements ScoreDAO{

	//DB로 가정
	private ArrayList<ScoreVO> list = new ArrayList<>();
	
	@Override
	public void regist(ScoreVO vo) {
		
		list.add(vo); //DB에 저장
		
		System.out.println("넘어오는값:" + vo.getName());
		System.out.println("넘어오는값:" + vo.getKor());
		System.out.println("넘어오는값:" + vo.getEng());
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		//DB관련 처리...
		
		return list;
	}
	
}
