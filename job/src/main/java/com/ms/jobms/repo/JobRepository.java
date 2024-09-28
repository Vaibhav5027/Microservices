package com.ms.jobms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.jobms.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}
