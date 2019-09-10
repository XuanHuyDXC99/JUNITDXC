/*
	Code of me
*/
package com.dxc.finalproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Brands")
public class Brand implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="brandscode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int brandId;
	
	
	@Column(name="brandscodename")
	private String brandName;


	public int getBrandId() {
		return brandId;
	}


	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
