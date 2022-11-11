package model;

import java.util.Date;

public class MemberDTO {
	/// DTO는 데이터베이스의 테이블이다.
	/// DTO의 멤버필드 디비의 테이블의 컬럼과 같다.
	/// 컬럼을 부를 때 필드라고도 한다. 
	/// 그래서 멤버필드라고도 한다.
	String memNum; 
	String memName;
	Date  memRegiDate;
	String memId;
	String memPw;
	String memPhone1;
	String memPhone2;
	String memAddr;
	String memEmail;
	String memGender;
	Date memBirth;
	///setter/getter
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public Date getMemRegiDate() {
		return memRegiDate;
	}
	public void setMemRegiDate(Date memRegiDate) {
		this.memRegiDate = memRegiDate;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemPhone1() {
		return memPhone1;
	}
	public void setMemPhone1(String memPhone1) {
		this.memPhone1 = memPhone1;
	}
	public String getMemPhone2() {
		return memPhone2;
	}
	public void setMemPhone2(String memPhone2) {
		this.memPhone2 = memPhone2;
	}
	public String getMemAddr() {
		return memAddr;
	}
	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemGender() {
		return memGender;
	}
	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}
	public Date getMemBirth() {
		return memBirth;
	}
	public void setMemBirth(Date memBirth) {
		this.memBirth = memBirth;
	}
}
