package com.ms.jobms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ms.jobms.dto.JobDTO;
import com.ms.jobms.model.Job;



public interface JobService {
  
 public ResponseEntity<List<JobDTO>>  findAllJobs();

public ResponseEntity<String> cretaJob(Job job);	

public ResponseEntity<JobDTO> findById(int id);

public ResponseEntity<String> deleteById(int id);

public ResponseEntity<String> updateJob(int id,Job job);
}
