package com.sh.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountDAO {

	public int update(AccountDTO accountDTO, Connection conn) throws Exception{
		int result = 0;
		String sql = "update account set balance = (select balance from account where id = ?)+? where account_num = (select account_num from account where id = ?)";
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1, accountDTO.getId());
		st.setLong(2, accountDTO.getBalance());
		st.setString(3, accountDTO.getId());
		
		result = st.executeUpdate();

		st.close();
		
		return result;
	}
	
	public int insert(AccountDTO accountDTO, Connection conn) throws Exception{
		int result =0;
		
		String sql = "insert into account values(?, ?, ?, 0, sysdate)";
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		st.setString(1, accountDTO.getAccountNum());
		st.setString(2, accountDTO.getAccountName());
		st.setString(3, accountDTO.getId());
		
		result = st.executeUpdate();
		
		st.close();
		
		return result;
		
	}

}
