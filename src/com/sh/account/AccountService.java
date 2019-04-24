package com.sh.account;

import java.util.EmptyStackException;
import java.util.Scanner;

import com.sh.member.MemberDTO;
import com.sh.util.DBConnector;
import com.sh.util.Session;

public class AccountService {
	private Scanner sc;
	private AccountDAO accountDAO;
	
	public AccountService() {
		sc = new Scanner(System.in);
		accountDAO = new AccountDAO();
	}
	
	public String insert() {
		String message = "계좌개설 성공";
	
		AccountDTO accountDTO = new AccountDTO();
		System.out.println("계좌번호 입력 : ");
		accountDTO.setAccountNum(sc.next());
		System.out.println("계좌명 입력 : ");
		accountDTO.setAccountName(sc.next());
		accountDTO.setId(((MemberDTO)(Session.member)).getId());
		int result = 0;
		try {
			result = accountDAO.insert(accountDTO, DBConnector.getConnection());
			if(result<1) {
				throw new Exception();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "계좌개설 실패";
		}
		return message;
	}

}
