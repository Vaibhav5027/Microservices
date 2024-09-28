package com.ms.review.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.review.model.Review;
import com.ms.review.repo.ReviewRepository;
import com.ms.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepo;

	@Override
	public List<Review> getAllReviews(Long companyId) {

		return reviewRepo.findByCompanyId(companyId);
	}

	@Override
	public String addReview(Long companyId, Review review) {
		if (companyId != null && review != null) {
			review.setCompanyId(companyId);
			reviewRepo.save(review);
			return "review added succefully";
		} else {
			return "company not found";
		}

	}

	@Override
	public String updateReview(Long reviewId, Review updatedReview) {
		Review review = reviewRepo.findById(reviewId).orElse(null);
		if (reviewId != null) {
            
			review.setTitle(updatedReview.getTitle() == null ? review.getTitle() : updatedReview.getTitle());
			review.setDescription(
					updatedReview.getDescription() == null ? review.getDescription() : updatedReview.getDescription());
			review.setRating(updatedReview.getRating() == null ? review.getRating() : updatedReview.getRating());
			review.setCompanyId(
					updatedReview.getCompanyId() == null ? review.getCompanyId() : updatedReview.getCompanyId());
			reviewRepo.save(review);
			return "review updated succefully";
		}
		return "Not Found";
	}

	@Override
	public String deleteReview(Long reviewId) {

		if (reviewId != null && reviewRepo.existsById(reviewId)) {
			reviewRepo.deleteById(reviewId);
			return "review deleted succesfully";

		}
		return "not found";
	}

	@Override
	public Review getReviewById(Long reviewId) {
		return reviewRepo.findById(reviewId).orElse(null);

	}

}
