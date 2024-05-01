package com.gangnampro2.hcproject2.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gangnampro2.hcproject2.dto.JoinDTO;
import com.gangnampro2.hcproject2.entity.Certificate;
import com.gangnampro2.hcproject2.entity.Member;
import com.gangnampro2.hcproject2.repository.CertificateRepositorty;
import com.gangnampro2.hcproject2.repository.MemberRepository;

@Service
public class BJoinService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private CertificateRepositorty cerRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void b_join(JoinDTO joinDto) {
		
		//db에 이미 동일한 id를 가진 회원이 존재하는지 검증 후 회원가입
		boolean isUser = memberRepository.existsBymemId(joinDto.getMemId());
		//true면(=id존재하면) 강제로 함수 리턴시킴
		if(isUser) {return;}
	
		//회원가입 > member 테이블
		Member member = new Member();
		
		member.setMemId(joinDto.getMemId());
		member.setMemPw(bCryptPasswordEncoder.encode(joinDto.getMemPw()));
		member.setMemNick(joinDto.getMemNick());
		member.setMemName(joinDto.getMemName());
		member.setMemBirth(joinDto.getMemBirth());
		member.setMemTel(joinDto.getMemTel());
		member.setMemActive("y");
		if(joinDto.getMemRole() == null) {
			member.setMemRole("ROLE_BUSINESS");
		}
		//오늘날짜
		Timestamp now = new Timestamp(System.currentTimeMillis());
		member.setMemReg(now);	
		
		//회원정보 insert
		System.out.println("joinDto:"+joinDto.getMemName());
		memberRepository.save(member);
		
		
		//자격증 정보 > certificate 테이블
		Certificate certificate = new Certificate();
		
		certificate.setCertId(joinDto.getMemId());
		certificate.setCertName(joinDto.getCertName());
		certificate.setCertReg(joinDto.getCertReg());
		certificate.setCertDepart(joinDto.getCertDepart());
		certificate.setCertPhoto(joinDto.getCertPhoto());

		//자격증 정보 insert
		System.out.println("joinDto:"+joinDto.getCertName());
		cerRepository.save(certificate);
		
	}
	
	
}
