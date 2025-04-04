package hkShoppungMall.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hkShoppungMall.domain.ReviewDTO;
import hkShoppungMall.repository.ReviewRepository;

@Service
public class ReviewListService {
	@Autowired
	ReviewRepository reviewRepository;
	public void execute(String goodsNum,Model model) {
		List<ReviewDTO> list =  reviewRepository.goodsReviewList(goodsNum);
		model.addAttribute("list", list);
	}
}
