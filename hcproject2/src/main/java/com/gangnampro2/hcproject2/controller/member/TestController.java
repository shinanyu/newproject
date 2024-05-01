package com.gangnampro2.hcproject2.controller.member;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gangnampro2.hcproject2.dto.CustomUserDetails;
import com.gangnampro2.hcproject2.entity.Member;

@Controller
public class TestController {

	@RequestMapping("/")
	public String test() {
		return "test";
	}
	
	@RequestMapping("test")
	public String test1(Authentication auth) {
		
		CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
		
		Member member =user.getMember();
		System.out.println("test:"+member.getMemId());
		return "test";
	}
	
}
