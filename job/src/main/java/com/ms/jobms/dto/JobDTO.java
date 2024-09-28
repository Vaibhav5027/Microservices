package com.ms.jobms.dto;

import java.util.List;

import com.ms.jobms.externalmodel.Company;
import com.ms.jobms.externalmodel.Review;

public class JobDTO {
	private int jobId;
	private String title;
	private String description;
	private String maxSalary;
	private String minSalary;
	private String location;
	private Company company;
	private List<Review> review;



	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

}
