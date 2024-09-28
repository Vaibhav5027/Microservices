package com.ms.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.company.model.Company;
import com.ms.company.service.CompanyService;



@RestController
@RequestMapping("/api/company/")
public class CompanyController {
	@Autowired
	CompanyService companyService;

	@GetMapping("/allCompanies")
	ResponseEntity<List<Company>> getCompanies() {
		return companyService.getAllCompanies();
	}
	
	@PutMapping("/updateCompany/{id}")
	ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
		return companyService.updateCompany(id,company);
	}
	
	@PostMapping("/addCompany")
	ResponseEntity<Company> addCompany (@RequestBody Company company){
		return companyService.addCompany(company);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		return companyService.deleteCompanyById(id);
	}
	
	@GetMapping("/companyById/{id}")
	ResponseEntity<Company> getCompaniesById(@PathVariable Long id) {
		return companyService.companyById(id);
	}
	
}
