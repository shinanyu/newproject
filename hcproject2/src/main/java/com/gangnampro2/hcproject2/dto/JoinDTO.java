package com.gangnampro2.hcproject2.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class JoinDTO {

	private String memId;
	private String memPw;
	private String memNick;
	private String memName;
	private String memBirth;
	private String memTel;
	private String memRole;
	private String memActive;
	private Timestamp memReg;
	private String certId;
	private String certName;
	private String certReg;	
	private String certDepart;
	private String certPhoto;
	
}
