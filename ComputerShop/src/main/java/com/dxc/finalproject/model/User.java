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
@Table(name = "Users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "usercode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username")
	private String userName;

	@Column(name = "userpassword")
	private String passWord;

	@Column(name = "userrole")
	private int userRole;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthday;

	@Temporal(TemporalType.DATE)
	@Column(name = "daytowork")
	private Date dayToWork;

	@Column(name = "addressuser")
	private String address;

	@Column(name = "Peopleid")
	private String peopleId;

	@Column(name = "sex")
	private boolean sex;

	@Column(name = "phonenumber")
	private String phoneNumber;

	public User() {
	}
	public User(String userName,String passWord,int userRole,String firstName,String lastName,Date birthday,Date dayToWork ,String peopleId,boolean sex,String phoneNumber )
	{
		super();
		this.userName =  userName;
		this.passWord = passWord;
		this.userRole = userRole;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday =  birthday;
		this.dayToWork = dayToWork;
		this.peopleId = peopleId;
		this.sex =sex;
		this.phoneNumber = phoneNumber;
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getDayToWork() {
		return dayToWork;
	}

	public void setDayToWork(Date dayToWork) {
		this.dayToWork = dayToWork;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPeopleId() {
		return peopleId;
	}

	public void setPeopleId(String peopleId) {
		this.peopleId = peopleId;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
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
