package com.simple.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;

//@Service 어노테이션은 @Controller와 같이 작동.
//@Service 어노테이션이 붙어있으면 스캔시 자동으로 bean 등록
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	@Qualifier("yyy")
	private ScoreDAO scoreDAO;
	
	public void regist(ScoreVO vo) {
		scoreDAO.regist(vo);
	}

	@Override
	public ArrayList<ScoreVO> getList() {
				
		return scoreDAO.getList();
	}

	@Override
	public void delete(int num) {
		
		scoreDAO.delete(num);
		
	}
	
	
	
}
