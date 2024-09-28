package com.ms.company.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ms.company.model.Company;
import com.ms.company.repo.CompanyRepository;
import com.ms.company.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	private CompanyRepository companyRepo;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepo = companyRepository;
	}

	@Override
	public ResponseEntity<List<Company>> getAllCompanies() {

		List<Company> companies = companyRepo.findAll();
		return new ResponseEntity<List<Company>>(companies, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> updateCompany(Long id, Company comp) {
		Optional<Company> company1 = companyRepo.findById(id);

		if (company1.isPresent()) {
			Company company = company1.get();
			company.setCompanyId(id);
			company.setDescription(comp.getDescription());
			company.setName(comp.getName());
//			company.setJobs(company.getJobs());
			companyRepo.save(company);
			return new ResponseEntity<String>("company details updated", HttpStatus.OK);
		}
		return new ResponseEntity<String>("company not found", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Company> addCompany(Company company) {
		Company save = companyRepo.save(company);
		return new ResponseEntity<Company>(save, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteCompanyById(Long id) {
		if (companyRepo.existsById(id)) {
			companyRepo.deleteById(id);
			return new ResponseEntity<String>("Company Deleted Succesfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Company Not Found", HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<Company> companyById(Long id) {
		Company comp = null;
		Optional<Company> findById = companyRepo.findById(id);
		if (findById.isPresent()) {
			comp = findById.get();
			return new ResponseEntity<Company>(comp, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Company>(comp, HttpStatus.NOT_FOUND);
		}

	}

}
