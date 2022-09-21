package com.blogs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Questionnaire")
@NamedQuery(name="Questionnaire.findAll", query = "SELECT m FROM Questionnaire m")
public class Questionnaire  extends BaseEntity{

    	@Id
	@Column(name="ID", unique=true, nullable=false)
	private int id;
	
	@Column(name="APPOINTMENT_TYPE",nullable=false)
	private String appointmentType;
	
	@Column(name="CUSTOMER_ID", nullable=false)
	private Integer customerId;
	
	@Column(name="CUSTOMER_NAME", nullable=false)
	private String customerName;
	
	@Column(name="IS_USED_SERVICE", nullable=false)
	private Boolean isUsedService;
	
	@Column(name="BRANCH")
	private String branch;
	
	@Column(name="CONECTION_CHANELS")
	private String conectionCannels;
	
	@Column(name="INTEREST_SERVICE")
	private String interestServices;
	
	@Column(name="IS_NEW_SURGERY")
	private Boolean isNewSurgery;
	
	@Column(name="SERIOUS_DISEASES")
	private String seriousDiseases;
	
	@Column(name="CONGENITAL_DISEASE")
	private String congenitalDisease;
	
	@Column(name="IS_FIX_SURGERY")
	private Boolean isFixSurgery;
	
	@Column(name="COUNT_SURGERY_TYPE")
	private String countSurgeryType;
	
	@Column(name="DRUG_NAME")
	private String drugName;
	
	@Column(name="IS_CONTINUE_TAKE_DRUG")
	private Boolean isContinueTakeDrug;
	
	@Column(name="DRUG_ALLERGY_NAME")
	private String drugAllergyName;
	
	@Column(name="LATEST_SURGERY_TIME")
	private String latestSurgeryTime;
	
	@Column(name="STOP_TAKE_DRUG_TIME")
	private String stopTakeDrugTime;
	
	@Column(name="ALL_SURGERES")
	private String allSurgeres;
	
	@Column(name="CERTAIN_DISEASES")
	private String certainDiseases;
	
	@Column(name="COUNT_ALL_SURGERY")
	private String countAllSurgery;
	
	@Column(name="SURGERY_CLINIC_NAME")
	private String surgeryClinicName;
	
	@Column(name="IS_OPEN_NOSE")
	private Boolean isOpenNose;
	
	@Column(name="USED_INJECT_NAME")
	private String usedInjectName;
	
	@Column(name="PROBLEM")
	private String problem;
	
	@Column(name="LATEST_INJECT_TIME")
	private String latestInjectTime;
	
	@Column(name="OTHER_INTEREST")
	private String otherInterest;
	
	@Column(name="OTHER_SURGERY")
	private String otherSurgery;
	
}
