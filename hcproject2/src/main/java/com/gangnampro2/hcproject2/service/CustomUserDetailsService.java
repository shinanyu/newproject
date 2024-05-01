package com.gangnampro2.hcproject2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gangnampro2.hcproject2.dto.CustomUserDetails;
import com.gangnampro2.hcproject2.entity.Member;
import com.gangnampro2.hcproject2.repository.MemberRepository;


// 로그인(/login) 요청 시 > 입력id값이 db에 존재하는지 확인해주는 클래스
// 확인 후 해당 id에 대한 모든 정보를 member변수에 저장해서 전달해줌 > CustomUserDetails클래스(dto객체)로 들고감
// login요청이 오면 자동으로 loadUserByUsername 함수가 실행

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberRepository memberRepository;
	
	//시큐리티 session = Authentication = UserDetails
	//로그인 검증 (사용자가 입력한 id값과 db에 저장된 id값 비교)
	@Override
	public UserDetails loadUserByUsername(String memId) throws UsernameNotFoundException {
		
			Member member = memberRepository.findByMemId(memId);
			
			System.out.println("memId:"+memId);		
			System.out.println("member:"+member);	
			
			// !=null > db에 data있음 > 로그인 진행
			if(member !=null) {
				return new CustomUserDetails(member);
			}
			return null;
		
	}

}
