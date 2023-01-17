package hkShoppungMall.service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.GoodsReviewDTO;
import hkShoppungMall.domain.ReviewDTO;
import hkShoppungMall.repository.ReviewRepository;

@Service
public class ReviewUpdateService {
	@Autowired
	ReviewRepository reviewRepository;
	public void execute(String reviewNum, Model model) {
		GoodsReviewDTO dto =reviewRepository.reviewGoodsSelect(reviewNum);
		model.addAttribute("dto", dto);
	}
	public void execute(Long reviewNum,String reviewContent) {
		ReviewDTO dto = new ReviewDTO();
		dto.setReviewNum(reviewNum);
		dto.setReviewContent(reviewContent);
		reviewRepository.reviewUpdate(dto);
	}
}
