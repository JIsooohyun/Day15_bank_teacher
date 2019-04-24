package com.sh.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sh.account.AccountDTO;
import com.sh.util.DBConnector;

public class MemberDAO {  //데이터베이스에 접근해서 집어넣거나 쿼리문을 날려라 //입력 , 출력 X
	
	//로그인
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		Connection conn = DBConnector.getConnection();
		
		//조인해서 두 테이블에서 결과값 가져오기 (Member기준)
		String sql = "select * from member where id = ? and pw = ?";
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {  //한줄 읽어봤을 때 데이터가 있다면 실행
			//성공했을 때 무엇을 return할 것 인가
			memberDTO.setName(rs.getString("name"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setEmail(rs.getString("email"));
		}else { //memberDTO가 null이면 로그인 안됨
			memberDTO = null;
		}
		DBConnector.disConnect(st, conn, rs);
		
		return memberDTO;
	}
	
	//회원가입 -> insert
	public int insert(MemberDTO memberDTO) throws Exception{
		int result = 0;
		Connection conn = DBConnector.getConnection();
		
		String sql = "insert into member values(?, ?, ?, ?, ?)";
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
		
		result = st.executeUpdate();
		
		DBConnector.disConnect(st, conn);
		
		return result;
	}
	
	
	
	

}
