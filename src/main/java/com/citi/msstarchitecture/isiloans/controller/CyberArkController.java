package com.citi.msstarchitecture.isiloans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.msstarchitecture.isiloans.cyberark.CyberArk;

@RestController
public class CyberArkController {
	
	@Value("${nickname}")
	String nickname;
	
	
	@Autowired
	CyberArk cyberArk;
	


	@RequestMapping("/secret")
	public String secret() {
		try {
			return this.cyberArk.getSecretFromNickname();
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	
	@RequestMapping("/nickname")
	public String nickname() {
		return "nickname app : " + this.nickname;
	}

}
