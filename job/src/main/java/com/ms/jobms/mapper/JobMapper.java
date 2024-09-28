package com.ms.jobms.mapper;

import java.util.List;

import com.ms.jobms.dto.JobDTO;
import com.ms.jobms.externalmodel.Company;
import com.ms.jobms.externalmodel.Review;
import com.ms.jobms.model.Job;

public class JobMapper {
 
	public static JobDTO jobMapper(Job job,Company company,List<Review> review) {
		JobDTO jobDTO =new JobDTO();
		jobDTO.setJobId(job.getJobId());
		jobDTO.setTitle(job.getTitle());
		jobDTO.setDescription(job.getDescription());
		jobDTO.setLocation(job.getLocation());
		jobDTO.setMaxSalary(job.getMaxSalary());
		jobDTO.setMinSalary(job.getMinSalary());
		jobDTO.setCompany(company);
		jobDTO.setReview(review);
		return jobDTO;
	}
	
}
