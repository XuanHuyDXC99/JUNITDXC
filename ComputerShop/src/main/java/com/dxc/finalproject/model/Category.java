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
@Table(name="Category")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="categorycode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	
	@Column(name="categoryname")
	private String categoryName;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
