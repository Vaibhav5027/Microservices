package com.ms.jobms.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ms.jobms.externalmodel.Company;

@FeignClient(name="COMPANY")
public interface CompanyClient {
  
	@GetMapping("/api/company/companyById/{id}")
	Company getCompany(@PathVariable Long id);
}
