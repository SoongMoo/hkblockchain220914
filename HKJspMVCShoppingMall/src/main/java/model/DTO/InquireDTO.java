package model.DTO;

import java.util.Date;

public class InquireDTO {
	long inquireNum;
	String memberNum;
	String goodsNum;
	String inquireSubject;
	String inquireContent;
	String employeeNum;
	String answerReply;
	Date answerDate;
	public long getInquireNum() {
		return inquireNum;
	}
	public void setInquireNum(long inquireNum) {
		this.inquireNum = inquireNum;
	}
	public String getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getInquireSubject() {
		return inquireSubject;
	}
	public void setInquireSubject(String inquireSubject) {
		this.inquireSubject = inquireSubject;
	}
	public String getInquireContent() {
		return inquireContent;
	}
	public void setInquireContent(String inquireContent) {
		this.inquireContent = inquireContent;
	}
	public String getEmployeeNum() {
		return employeeNum;
	}
	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}
	public String getAnswerReply() {
		return answerReply;
	}
	public void setAnswerReply(String answerReply) {
		this.answerReply = answerReply;
	}
	public Date getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}
}
