package model.DTO;

import java.util.Date;

public class GoodsDTO {
	String goodsNum;
	String goodsName;
	int goodsPrice;
	String goodsContent;
	String company;
	Date goodsRegiDate;
	Date goodsUptDate;
	String employeeNum;
	String employeeUptNum;
	String goodsImage;
	public String getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsContent() {
		return goodsContent;
	}
	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getGoodsRegiDate() {
		return goodsRegiDate;
	}
	public void setGoodsRegiDate(Date goodsRegiDate) {
		this.goodsRegiDate = goodsRegiDate;
	}
	public Date getGoodsUptDate() {
		return goodsUptDate;
	}
	public void setGoodsUptDate(Date goodsUptDate) {
		this.goodsUptDate = goodsUptDate;
	}
	public String getEmployeeNum() {
		return employeeNum;
	}
	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}
	public String getEmployeeUptNum() {
		return employeeUptNum;
	}
	public void setEmployeeUptNum(String employeeUptNum) {
		this.employeeUptNum = employeeUptNum;
	}
}
