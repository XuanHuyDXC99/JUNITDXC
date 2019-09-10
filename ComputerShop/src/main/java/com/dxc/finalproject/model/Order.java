/*
	Code of me
*/
package com.dxc.finalproject.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bill")
public class Order implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="codebill")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@Column(name="total")
	private BigDecimal total;
	
	@Column(name="dateOrdate")
	private Date dateOrder;
	
	@Column(name="usercode")
	private int userId;
	
	@Column(name="customercode")
	private int customerId;
	
	
	
	public Order() {
		super();
	}

	public Order(int orderId, BigDecimal total, Date dateOrder, int userId, int customerId) {
		super();
		this.orderId = orderId;
		this.total = total;
		this.dateOrder = dateOrder;
		this.userId = userId;
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
