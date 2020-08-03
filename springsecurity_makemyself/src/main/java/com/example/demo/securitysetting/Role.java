package com.example.demo.securitysetting;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
	
	ADMIN("ROLE_ADMIN"),
	MEMBER("ROLE_MEMBER"),
	USER("ROLE_USER");
	private String value;

}
