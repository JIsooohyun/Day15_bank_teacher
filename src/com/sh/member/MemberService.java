package com.sh.member;

import java.util.Scanner;

import com.sh.util.Session;

public class MemberService {  //입력받는 용도로 쓰이고 있다. 
	
	
	private Scanner sc;
	private MemberDAO memberDAO;
	
	public MemberService() {
		sc = new Scanner(System.in);
		memberDAO = new MemberDAO();
	}
	
	public String login() {
		MemberDTO memberDTO = new MemberDTO();
		
		System.out.println("ID : ");
		memberDTO.setId(sc.next());
		System.out.println("PW : ");
		memberDTO.setPw(sc.next());
		String message = "로그인 실패";
		try {
			memberDTO = memberDAO.login(memberDTO);
			Session.member = memberDTO;  //다형성을 통해서 가능~가능~가능~~~~  //로그인이 안됬을 경우 null값이다.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(memberDTO != null) {
			message = "로그인 성공";
		}
		
		return message;
		
	}
	public String insert() {
		MemberDTO memberDTO = new MemberDTO();
		
		System.out.println("ID : ");
		memberDTO.setId(sc.next());
		System.out.println("PW : ");
		memberDTO.setPw(sc.next());
		System.out.println("Name : ");
		memberDTO.setName(sc.next());
		System.out.println("Phone : ");
		memberDTO.setPhone(sc.next());
		System.out.println("Email : ");
		memberDTO.setEmail(sc.next());
		
		int result = 0;
		String message = "회원가입 성공";
		try {
			result = memberDAO.insert(memberDTO);
			if(result <1) {//0이하가 된다면
				throw new Exception();  //오류를 던져버리겠습니다. 강제로 예외 발생
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = "회원가입 실패";
		}
		
		return message;
		
	}

}
