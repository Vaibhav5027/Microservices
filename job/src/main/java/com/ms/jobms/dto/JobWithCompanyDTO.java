package com.ms.jobms.dto;

import com.ms.jobms.externalmodel.Company;
import com.ms.jobms.model.Job;

public class JobWithCompanyDTO {
private Job job;
private Company company;
public Job getJob() {
	return job;
}
public void setJob(Job job) {
	this.job = job;
}
public Company getCompany() {
	return company;
}
public void setCompany(Company company) {
	this.company = company;
}

}
