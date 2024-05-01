package com.gangnampro2.hcproject2.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "certificate")
public class Certificate {
	
	@Id
	@Column(name="cert_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int certNo;
	
	@Column(name="cert_id", length = 100, nullable = false)
	private String certId;
	
	@Column(name="cert_name", length = 200, nullable = false)
	private String certName;
	
	@Column(name="cert_reg", length = 100, nullable = false)
	private String certReg;
	
	@Column(name="cert_depart", length = 200, nullable = false)
	private String certDepart;
	
	@Column(name="cert_photo")
	private String certPhoto;

}

