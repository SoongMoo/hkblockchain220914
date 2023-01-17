package hkShoppungMall.service.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.ReviewDTO;
import hkShoppungMall.repository.ReviewRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class ReviewWriteService {
	@Autowired
	ReviewRepository reviewRepository;
	public void execute(String goodsNum, String reviewContent,String purchaseNum,
				HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		ReviewDTO dto = new ReviewDTO();
		dto.setGoodsNum(goodsNum);
		dto.setPurchaseNum(purchaseNum);
		dto.setReviewContent(reviewContent);
		dto.setMemberId(authInfo.getUserId());
		reviewRepository.reviewWrite(dto);
	}
}
