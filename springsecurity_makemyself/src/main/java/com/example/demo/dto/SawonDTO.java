package com.example.demo.dto;
/*create table sawon(
s_num number CONSTRAINT product_pk PRIMARY KEY,
s_id varchar2(256),
s_pw varchar2(256),
s_name varchar2(50),
s_some varchar2(50),
s_gender varchar2(50),
s_favorit varchar2(50),
s_check number
)*/

import com.example.demo.securitysetting.SawonEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SawonDTO {
	private Long s_num;
	private int s_check;
	private String s_id,s_pw,s_name,s_some,s_gender,s_favorit;
	
	public SawonEntity toEntity() {
		return SawonEntity.builder()
				.s_num(s_num).s_check(s_check)
				.sid(s_id).s_pw(s_pw).s_name(s_name)
				.s_some(s_some).s_gender(s_gender)
				.s_favorit(s_favorit).build();
	}
	@Builder
	public SawonDTO(Long s_num, int s_check, String s_id, String s_pw, String s_name, String s_some, String s_gender,
			String s_favorit) {
		super();
		this.s_num = s_num;
		this.s_check = s_check;
		this.s_id = s_id;
		this.s_pw = s_pw;
		this.s_name = s_name;
		this.s_some = s_some;
		this.s_gender = s_gender;
		this.s_favorit = s_favorit;
	}
	
	
	
	
}
