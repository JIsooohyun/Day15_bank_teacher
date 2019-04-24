package com.sh.control;

import java.util.Scanner;

import com.sh.account.AccountService;
import com.sh.ti.TranService;
import com.sh.view.View;

public class AccountController {
	private TranService tranService;
	private Scanner sc;
	private AccountService accountService;
	private View view;
	
	public AccountController() {
		tranService = new TranService();
		accountService = new AccountService();
		view = new View();
		sc = new Scanner(System.in);
	}
	
	public void start() {
		boolean check = true;
		String message = "";
		while(check) {
			System.out.println("1. 계좌개설");
			System.out.println("2. 입금 ");
			System.out.println("3. 출금");
			System.out.println("4. 종료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				message = accountService.insert();
				view.view();
				break;
			case 2:
				message = tranService.tran(0);
				view.view(message);
				break;
			case 3:
				message = tranService.tran(1);
				view.view(message);
				break;
			default :
				check = ! check;
			}
		}
	}

}
