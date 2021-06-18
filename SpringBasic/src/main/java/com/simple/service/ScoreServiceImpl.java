package com.simple.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.dao.ScoreDAO;
import com.simple.mapper.ScoreMapper;

//@Service 어노테이션은 @Controller와 같이 작동.
//@Service 어노테이션이 붙어있으면 스캔시 자동으로 bean 등록
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

//	@Autowired
//	@Qualifier("yyy")
//	private ScoreDAO scoreDAO;

	@Autowired
	private ScoreMapper scoreMapper;
		
	@Override
	public void regist(ScoreVO vo) {
		//1번째 방법
		//scoreMapper.regist(vo);
		
		//2번째 방법; 맵으로 전달하기
		HashMap<String, String> map = new HashMap<>();
		map.put("name", vo.getName());
		map.put("kor", vo.getKor());
		map.put("eng", vo.getEng());
		
		scoreMapper.regist(map);
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		return scoreMapper.getList();
	}

	@Override
	public void delete(int num) {
		scoreMapper.delete(num);
	}

	
}
