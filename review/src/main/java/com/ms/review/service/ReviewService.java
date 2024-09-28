package com.ms.review.service;

import java.util.List;

import com.ms.review.model.Review;



public interface ReviewService {
	List<Review> getAllReviews(Long companyId);
	
	Review getReviewById(Long reviewId);
	
	String updateReview(Long reviewId,Review review);
	
	String addReview(Long companyId,Review review);
	
	String deleteReview(Long reviewId);
}
