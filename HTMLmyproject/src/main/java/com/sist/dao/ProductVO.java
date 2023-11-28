package com.sist.dao;
/*
 * FNO    NOT NULL NUMBER
 POSTER   NOT NULL VARCHAR2(1000)
 NAME     NOT NULL VARCHAR2(300)
 TYPE     NOT NULL VARCHAR2(100)
 ADDRESS  NOT NULL VARCHAR2(500)
 PHONE   NOT NULL VARCHAR2(100)
 SCORE      NUMBER(2,1)
 THEME      NOT NULL VARCHAR2(4000)
 PRICE    VARCHAR2(100)
 TIME      VARCHAR2(200)
 SEAT        VARCHAR2(100)
 CONTENT    CLOB
 LINK     VARCHAR2(300)
 */
public class ProductVO{
private int pno,product_rank,product_stack;
private String product_name,product_price,p_image,product_sale,sale_price,shipment,product_category,product_expire_date;
private double product_grade;
public int getPno() {
	return pno;
}
public void setPno(int pno) {
	this.pno = pno;
}
public int getProduct_rank() {
	return product_rank;
}
public void setProduct_rank(int product_rank) {
	this.product_rank = product_rank;
}
public int getProduct_stack() {
	return product_stack;
}
public void setProduct_stack(int product_stack) {
	this.product_stack = product_stack;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getProduct_price() {
	return product_price;
}
public void setProduct_price(String product_price) {
	this.product_price = product_price;
}
public String getP_image() {
	return p_image;
}
public void setP_image(String p_image) {
	this.p_image = p_image;
}
public String getProduct_sale() {
	return product_sale;
}
public void setProduct_sale(String product_sale) {
	this.product_sale = product_sale;
}
public String getSale_price() {
	return sale_price;
}
public void setSale_price(String sale_price) {
	this.sale_price = sale_price;
}
public String getShipment() {
	return shipment;
}
public void setShipment(String shipment) {
	this.shipment = shipment;
}
public String getProduct_category() {
	return product_category;
}
public void setProduct_category(String product_category) {
	this.product_category = product_category;
}
public String getProduct_expire_date() {
	return product_expire_date;
}
public void setProduct_expire_date(String product_expire_date) {
	this.product_expire_date = product_expire_date;
}
public double getProduct_grade() {
	return product_grade;
}
public void setProduct_grade(double product_grade) {
	this.product_grade = product_grade;
}
}