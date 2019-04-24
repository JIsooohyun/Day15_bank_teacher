package com.sh.view;

import com.sh.member.MemberDTO;
import com.sh.util.Session;

public class View {

	public void view() {
		//myPage -> 로그인 했을 경우 모든 정보가 Session.member에 있다. 
		MemberDTO memberDTO = (MemberDTO)Session.member;
		System.out.println("ID : "+memberDTO.getId());
		System.out.println("NAME : "+memberDTO.getName());
		System.out.println("PHONE : "+memberDTO.getPhone());
		System.out.println("EMAIL : "+memberDTO.getEmail());
		
	}
	
	public void view(String message) {
		System.out.println(message);
	}
}
