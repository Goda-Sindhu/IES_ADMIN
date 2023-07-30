package com.example.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Ies_Plans")
public class IesPlansEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planId;
	private String planName;
	private LocalDate startDate;
	private LocalDate endDate;
	private String planCategory;
	private String activeSwitch;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdDate;
	@UpdateTimestamp
	private LocalDate updatedDate;
	private String createdBy;
	private String updatedBy;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "userId")
	private IesUserEntity user;
	
	//@OneToOne(mappedBy = "planid", cascade=CascadeType.ALL, fetch=FetchType.EAGER,orphanRemoval=true)
	//private DCPlanSelectionEntity planSelection;

			
}
