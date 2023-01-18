package hkShoppungMall.service.inquire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.repository.InquireRepository;

@Service
public class GoodsInquireDeleteService {
	@Autowired
	InquireRepository inquireRepository;
	public Integer execute(String inquireNum ) {
		return inquireRepository.inquireDelete(inquireNum);
	}
}
