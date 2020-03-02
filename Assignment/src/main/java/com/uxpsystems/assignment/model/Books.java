package com.uxpsystems.assignment.model;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotEmpty;

//import com.uxpsystems.assignment.config.Employee.status;

@Entity
@Table

public class Books
{

@Id
@Column
private int bookid;
//@NotEmpty
@Column(nullable = false, unique = true)
private String username;

@Column
private String password;

public enum  name {
    ACTIVATED("activated"),
    DEACTIVATED("deactivated");
    
    private String value;

	private name(String value) {
		this.value = value;
	}

	public static name fromValue(String value) {
		for (name category : values()) {
			if (category.value.equalsIgnoreCase(value)) {
				return category;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}

@Column
@Enumerated(EnumType.STRING)
private name status;

public Books(int bookid, String username, String password,name status) {
	super();
	this.bookid=bookid;
	this.username=username;
	this.password=password;
	this.status=status;
	// TODO Auto-generated constructor stub
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}

public name getStatus() {
	return status;
}
public void setStatus(name status) {
	this.status = status;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}