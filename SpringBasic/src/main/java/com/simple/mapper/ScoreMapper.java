package com.simple.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.simple.command.ScoreVO;

@Mapper
public interface ScoreMapper {
	public void regist(ScoreVO vo);
	public void regist(HashMap<String, String> map);
	public ArrayList<ScoreVO> getList();
	public void delete(int num);
}
