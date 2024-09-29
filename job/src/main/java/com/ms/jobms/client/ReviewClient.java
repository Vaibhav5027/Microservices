package com.ms.jobms.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ms.jobms.externalmodel.Review;

@FeignClient(name = "REVIEW")
public interface ReviewClient {

	@GetMapping("/api/reviews")
	List<Review> getReview(@RequestParam("companyId") Long companyId);
}
