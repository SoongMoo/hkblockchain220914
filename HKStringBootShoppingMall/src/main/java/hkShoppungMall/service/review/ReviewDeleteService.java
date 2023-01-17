package hkShoppungMall.service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.repository.ReviewRepository;

@Service
public class ReviewDeleteService {
	@Autowired
	ReviewRepository reviewRepository;
	public void execute(String reviewNum) {
		reviewRepository.reviewDelete(reviewNum);
	}
}
