package com.sh.control;

import java.util.Scanner;

import com.sh.member.MemberDAO;
import com.sh.member.MemberService;
import com.sh.util.Session;
import com.sh.view.View;

public class MemberController {
	
	private Scanner sc;
	private AccountController accountController;
	private MemberDAO memberDAO;
	private MemberService memberService;
	private View view;
	public MemberController() {
		accountController = new AccountController();
		sc = new Scanner(System.in);
		view = new View();
		memberDAO = new MemberDAO();
		memberService = new MemberService();
	}

	public void start() {
		boolean check = true;
		String message = null;
		while(check) {
			if(Session.member != null) {
				System.out.println("1. MY page\t 2. logout\t 3. 계좌 관리");  //로그인 했을 때 보이는 창
				int select= sc.nextInt();
				if(select == 1) {
					view.view();
				}else if(select == 2) {
					Session.member = null;
				}else {
					accountController.start();
				}
				
			}else {
				System.out.println("1. 회원가입");  //로그인 안됬을 경우 보이는 창
				System.out.println("2. 로그인");  //로그인 안됬을 경우 보이는 창
				System.out.println("종료 ");
				int select = sc.nextInt();
				switch(select) {
				case 1:
					message = memberService.insert();
					view.view(message);
					break;
				case 2:
					message = memberService.login();
					view.view(message);
					break;
				default :
					check =! check;
					
				}
			}
			
			
		
		}
	}
}
