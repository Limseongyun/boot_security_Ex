package com.example.demo.securitysetting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


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
@Entity
@Table(name = "sawon")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SawonEntity {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "num_sequence")
	@SequenceGenerator(name = "num_sequence",allocationSize = 1,sequenceName = "sawon_seq")
	private Long s_num;
	@Column(name = "s_id")
	private String sid;
	@Column
	private String s_pw;
	@Column
	private String s_name;
	@Column
	private String s_gender;
	@Column
	private String s_favorit;
	@Column
	private int s_check;
	@Column
	private String s_some;
	
	@Builder
	public SawonEntity(Long s_num, String sid, String s_pw, String s_name, String s_gender, String s_favorit,
			int s_check, String s_some) {
		super();
		this.s_num = s_num;
		this.sid = sid;
		this.s_pw = s_pw;
		this.s_name = s_name;
		this.s_gender = s_gender;
		this.s_favorit = s_favorit;
		this.s_check = s_check;
		this.s_some = s_some;
	}
	
	
}
