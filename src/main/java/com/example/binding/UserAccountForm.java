package com.example.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserAccountForm {
	
	private String fullName;
	private String emailId;
	private Long phone;
	private LocalDate dob;
	private Integer ssno;
	private String gender;
	private Integer roleId;

}
