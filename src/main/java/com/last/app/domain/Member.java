package com.last.app.domain;
import lombok.Data;

@Data
public class Member {
	private int member_id;
	private String id;
	private String password;
	private String name;
	private String phone;
	private String email;
	private String regdate;	
}
