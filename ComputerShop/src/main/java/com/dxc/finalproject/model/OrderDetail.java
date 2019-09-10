/*
	Code of me
*/
package com.dxc.finalproject.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BillDeTail")
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "invoicedetailscode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderDetailId;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "singlePrice")
	private BigDecimal price;

	@Column(name = "codebill")
	private int orderId;

	@Column(name = "productcode")
	private int productId;

	public OrderDetail() {
		super();
	}

	public OrderDetail(int orderDetailId, int quantity, BigDecimal price, int orderId, int productId) {
		super();
		this.orderDetailId = orderDetailId;
		this.quantity = quantity;
		this.price = price;
		this.orderId = orderId;
		this.productId = productId;
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
