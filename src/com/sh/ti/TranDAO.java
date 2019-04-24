package com.sh.ti;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TranDAO {

	//insert
	public int insert(TranDTO tranDTO, Connection conn, String id) throws Exception{
		int result = 0;
		String sql = "insert into TransctionInfo values (TransctionInfo_SEQ.nextVal, (select account_num from account where id=?), ?, ?, sysdate)";
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1, tranDTO.getAccountNum());
		st.setInt(2, tranDTO.getAmount());
		st.setInt(3, tranDTO.getKind());
		
		result = st.executeUpdate();
		
		st.close();
		
		return result;
	}
}
