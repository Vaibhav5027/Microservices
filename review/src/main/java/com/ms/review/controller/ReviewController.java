package com.ms.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.review.model.Review;
import com.ms.review.service.ReviewService;

@RestController
@RequestMapping("api/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping
	ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
		List<Review> allReviews = reviewService.getAllReviews(companyId);
		return new ResponseEntity<List<Review>>(allReviews, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review){
		String msg = reviewService.addReview(companyId, review);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@PutMapping("/update/{reviewId}")
	ResponseEntity<String> updateReview( @PathVariable Long reviewId, @RequestBody Review review){
		String msg = reviewService.updateReview(reviewId, review);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/{reviewId}")
	ResponseEntity<Review> reviewsById( @PathVariable Long reviewId) {
		Review reviewById = reviewService.getReviewById(reviewId);
		if(reviewById!=null) {
			return new ResponseEntity<Review>(reviewById, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Review>(reviewById, HttpStatus.NOT_FOUND);

		}
	}
	@DeleteMapping("/delete/{reviewId}")
	ResponseEntity<String> deleteReview( @PathVariable Long reviewId){
		String msg = reviewService.deleteReview(reviewId);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
}
