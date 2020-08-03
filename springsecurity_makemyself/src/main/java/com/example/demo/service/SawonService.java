package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SawonDTO;
import com.example.demo.repository.SawonRepository;
import com.example.demo.securitysetting.Role;
import com.example.demo.securitysetting.SawonEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SawonService implements UserDetailsService {
	
	private SawonRepository sawonrepository;
	
	public Long join(SawonDTO sawondto) {
		BCryptPasswordEncoder passwordencoder = new BCryptPasswordEncoder();
		sawondto.setS_pw(passwordencoder.encode(sawondto.getS_pw()));
		return sawonrepository.save(sawondto.toEntity()).getS_num();
	}
	
	@Override
	public UserDetails loadUserByUsername(String s_id) throws UsernameNotFoundException {

		Optional<SawonEntity> userEntityWrapper = sawonrepository.findBysid(s_id);
		SawonEntity userEntity = userEntityWrapper.get();
		System.out.println("checkval"+userEntity.getS_check());
		int roleval = userEntity.getS_check();
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(("lsy").equals(s_id)) {
			authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
		}else {
			if(roleval==1) {
				authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
			}else if(roleval==2) {
				authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
			}else {
				authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
			}
		}
		return new User(userEntity.getSid(),userEntity.getS_pw(),authorities);
	}

}
