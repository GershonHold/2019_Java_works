/**
 * 
 */
package com.Students;

/**
 
 * @version 2019��8��21������7:31:25
 * @author Gershon
 *
 * 
 */
public class User {
	
	private String username;
	private String password;
	private String sex;
	private int score;
	public User(String username,String password) {
		this.username=username;
		this.password=password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
	
