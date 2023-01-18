package hkShoppungMall.service.inquire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.InquireGoodsDTO;
import hkShoppungMall.repository.InquireRepository;

@Service
public class GoodsInquireDetailService {
	@Autowired
	InquireRepository inquireRepository;
	public void execute(String inquireNum, Model model) {
		InquireGoodsDTO dto = inquireRepository.inquireGoodsSelect(inquireNum);
		model.addAttribute("dto", dto);
	}
}
