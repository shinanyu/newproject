package com.gangnampro2.hcproject2.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "member")
public class Member {
	
	@Id
	@Column(name="mem_id", length = 100)
	private String memId;
	
	@Column(name="mem_pw", length = 60, nullable = false)	
	private String memPw;
	
	@Column(name="mem_nick", length = 100, nullable = false, unique=true)
	private String memNick;
	
	@Column(name="mem_name", length = 50, nullable = false)
	private String memName;
	
	@Column(name="mem_birth", length = 40, nullable = false)
	private String memBirth;
	
	@Column(name="mem_tel", length =50, nullable = false)
	private String memTel;
	
	@Column(name="mem_role")
	private String memRole;
	
	@ColumnDefault("'y'")
	@Column(name="mem_active")
	private String memActive;
	
	@CreationTimestamp
	@Column(name="mem_reg")
	private Timestamp memReg;
}

