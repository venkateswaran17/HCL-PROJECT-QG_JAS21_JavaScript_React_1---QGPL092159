package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Bill1234")
public class Bill {
	
	@Id
	@Column(name = "billId")
	private int billId;
	@Column(name = "totalAmount")
	private String totalAmount;
	
	public Bill() {
		
	}
	
	public Bill(int billId, String totalAmount) {
		super();
		this.billId = billId;
		this.totalAmount = totalAmount;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
