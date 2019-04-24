package com.sh.member;

import com.sh.account.AccountDTO;

public class MemberDTO {
	
	private String id;

    private String pw;

    private String name;

    private String phone;

    private String email;

    private AccountDTO accountDTO;  //상속받지 않은 이유는 member is a Account -> ???이상해 //회원이 계정정보를 가지고 있다. 
    
    public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() { 
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
