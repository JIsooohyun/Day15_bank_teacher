package com.sh.ti;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.sh.account.AccountDAO;
import com.sh.account.AccountDTO;
import com.sh.member.MemberDTO;
import com.sh.util.DBConnector;
import com.sh.util.Session;

public class TranService {
	private AccountDAO accountDAO;
	private Scanner sc;
	private TranDAO tranDAO;
	
	public TranService() {
		accountDAO = new AccountDAO();
		tranDAO =new TranDAO();
		sc = new Scanner(System.in);
		
	}

	public String tran(int num) {
		String message = "입금";
		int kind=1;
		if(num!=0) {
			message = "출금";
			kind = -1;
		}
		System.out.println(message +" 금액 입력" );
		TranDTO tranDTO = new TranDTO();
		//accountNum, amount, kind
		tranDTO.setAmount(sc.nextInt());
		tranDTO.setKind(num);
		
		int result = 0;
		String id = ((MemberDTO)Session.member).getId();
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			conn.setAutoCommit(false);
			result = tranDAO.insert(tranDTO, conn, id);
			
			if(result<1) {
				throw new Exception();
			}
			AccountDTO accountDTO = new AccountDTO();
			accountDTO.setBalance((long)(tranDTO.getAmount()*kind));
			accountDTO.setId(id);
			result = accountDAO.update(accountDTO, conn);
			if(result<1) {
				throw new Exception();
			}
			conn.commit();
			message = message +"성공";
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			message = message + "실패";
		}
		
		
		
		
		//입금, 출금
		
		return message;
	}
}
