package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simple.command.ScoreVO;

@Repository("yyy")
public class ScoreDAOImpl implements ScoreDAO{

	@Autowired
	private DataSource dataSource;
	
	@Override
	public void regist(ScoreVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into T_SCORE values (t_score_seq.nextval, ?, ?, ?)";
		
		try {
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getKor());
			pstmt.setString(3, vo.getEng());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {

			}
		}
		
	}

	@Override
	public ArrayList<ScoreVO> getList() {

		ArrayList<ScoreVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from T_SCORE";

		try {
		
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setBno(rs.getInt("bno"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getString("kor"));
				vo.setEng(rs.getString("eng"));
			
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return list;
	}

	@Override
	public void delete(int num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from t_score where bno=?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

//	//DB??? ??????
//	private ArrayList<ScoreVO> list = new ArrayList<>();
//	
//	@Override
//	public void regist(ScoreVO vo) {
//		list.add(vo); //DB??? ??????
//		
//		System.out.println("???????????????:" + vo.getName());
//		System.out.println("???????????????:" + vo.getKor());
//		System.out.println("???????????????:" + vo.getEng());
//	}
//
//	@Override
//	public ArrayList<ScoreVO> getList() {
//		//DB?????? ??????...
//		return list;
//	}
//
//	@Override
//	public void delete(int num) {
//		list.remove(num);
//	}
	
}
