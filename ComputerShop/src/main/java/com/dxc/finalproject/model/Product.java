/*
	Code of me
*/
package com.dxc.finalproject.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "productcode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;

	@Column(name = "productname")
	private String pName;

	@Column(name = "productprice")
	private BigDecimal price;


	@Column(name = "inventory")
	private int quantity;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categorycode" , nullable = false)
	private Category category;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brandscode" , nullable = false)
	private Brand brand;
	
	
	

	public Product() {
		super();
	}

	public Product(String pName, BigDecimal price, int quantity, Category category, Brand brand) {
		super();
		this.pName = pName;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.brand = brand;
	}




	public int getPid() {
		return pid;
	}




	public void setPid(int pid) {
		this.pid = pid;
	}




	public String getpName() {
		return pName;
	}




	public void setpName(String pName) {
		this.pName = pName;
	}




	public BigDecimal getPrice() {
		return price;
	}




	public void setPrice(BigDecimal price) {
		this.price = price;
	}




	public int getQuantity() {
		return quantity;
	}




	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	public Brand getBrand() {
		return brand;
	}




	public void setBrand(Brand brand) {
		this.brand = brand;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
