package com.example.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Ies_User")
public class IesUserEntity {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer userId;
	
	private String fullName;
	private String emailId;
	private String pass;
	private Long phone;
	private LocalDate dob;
	private Integer ssno;
	private String gender;
	private String activeStatus;
	private String activeSwitch;
	
	private Integer roleId;
	
	@CreationTimestamp
	private LocalDate createDate;
	
	@UpdateTimestamp
	private LocalDate updatedDate;
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch=FetchType.EAGER,orphanRemoval=true)
	private List<IesPlansEntity> plans;
	
	//@OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch=FetchType.EAGER,orphanRemoval=true)
	//private List<IesCitizenAppsEntity> apps;
	
	private String createdBy;
	private String updateBy;
	
}
