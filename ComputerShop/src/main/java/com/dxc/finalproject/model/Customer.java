/*
	Code of me
*/
package com.dxc.finalproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="customercode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="customername")
	private String customerName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="sex")
	private boolean sex;
	
	@Column(name="addressct")
	private String address;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="phonenumber")
	private String phoneNumber;
	
	
	
	public Customer() {
		super();
	}

	public Customer( String customerName, Date birthday, boolean sex, String address, String email,
			String phoneNumber) {
		super();
		this.customerName = customerName;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
