package com.example.demo.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.SawonDTO;
import com.example.demo.service.SawonService;

@Controller
public class Logincontroller {
	@Autowired
	private SawonService sawonservice;
	
	//����������
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	//ȸ������������
	@GetMapping("/user/join")
	public String join() {
		return"join";
	}
	//ȸ������ó��
	@PostMapping("/user/join")
	public String execjoin(SawonDTO sawondto) {
		sawonservice.join(sawondto);
		return"redirect:/user/login";
	}
	
	//�α�������
	@GetMapping("/user/login")
	public String login() {
		return "login";
	}
	// �α��� ��� ������
    @GetMapping("/user/login/result")
    public String dispLoginResult(Principal principal,HttpSession session,HttpServletRequest req) {
    	System.out.println(principal.getName());
    	  
    	System.out.println(session.getAttribute(principal.getName()));
    	List<GrantedAuthority> authorities = new ArrayList<>();
    	for (GrantedAuthority e : authorities) {
    		System.out.println(e.getAuthority());
    		
    	}
    	
    	
    	
        return "loginSuccess";
    }
	//�α׾ƿ� ��� ������
	@GetMapping("/user/logout/result")
	public String logout() {
		return "logout";
	}
	//���� �ź� ������
	@GetMapping("/user/denied")
	public String denied() {
		return"denied";
	}
	//����������
	@GetMapping("/admin/info")
	public String admin() {
		return"adminmenu";
	}
	//���������
	@GetMapping("/member/info")
	public String member() {
		return"membermenu";
	}
	//����������
	@GetMapping("/user/info")
	public String user() {
		return"usermenu";
	}
}
