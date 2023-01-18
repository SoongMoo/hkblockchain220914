package hkShoppungMall.service.inquire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.domain.InquireDTO;
import hkShoppungMall.repository.InquireRepository;

@Service
public class InquireAnswerWriteService {
	@Autowired
	InquireRepository inquireRepository;
	public void execute(Integer inquireNum, String inquireAnswer, 
			String answerEmail,String inquireSubject) {
		InquireDTO dto = new InquireDTO();
		dto.setInquireNum(inquireNum);
		dto.setInquireAnswer(inquireAnswer);
		inquireRepository.inquireAnswer(dto);
	}
}
