package hkShoppungMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias("inquireDTO")
public class InquireDTO {
	Integer inquireNum;
	String memberNum;
	String goodsNum;
	String inquireKind;
	String inquireSubject;
	String inquireContent;
	Date inquireDate;
	String inquireAnswer; // 답변
	Date answerDate;
	String answerEmail; // 답변 받을 이메일
	
	String memberId;
}
