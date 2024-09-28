package com.ms.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.company.model.Company;



public interface CompanyRepository extends JpaRepository<Company,Long> {

}
