package com.gangnampro2.hcproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gangnampro2.hcproject2.entity.Certificate;

@Repository
public interface CertificateRepositorty extends JpaRepository<Certificate, Integer>{

	
}
