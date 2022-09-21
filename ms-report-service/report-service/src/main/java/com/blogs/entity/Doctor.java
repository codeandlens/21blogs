package com.blogs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Doctor")
@NamedQuery(name = "Doctor.findAll", query = "SELECT m FROM Doctor m")
public class Doctor extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name="CODE", nullable=false)
    private String code;
    
    @Column(name="FIRST_NAME_TH", nullable=false)
    private String firstNameTh;
    
    @Column(name="LAST_NAME_TH", nullable=false)
    private String lastNameTh;
    
    @Column(name="FIRST_NAME_EN", nullable=false)
    private String firstNameEn;
    
    @Column(name="LAST_NAME_EN", nullable=false)
    private String lastNameEn;
    
    @Column(name="NICK_NAME", nullable=false)
    private String nickName;
    
//    @Column(name="APPOINTMENT_TYPE", nullable=false)
//    private String appointmentType;
    
    @Column(name="GENDER", nullable=false)
    private String gender;
    
    @Column(name="DESCRIPTION", nullable=true)
    private String description;
    
    @Column(name="MEDICAL_LICENSE_NO", nullable=false)
    private String medicalLicenseNo;
    
    @Lob
    @Column(name = "PHOTO", nullable = true, length=1048576)
    private String photo;
    
    @Column(name="MEDICAL_LICENSE", nullable=false)
    private String medicalLicense;
    
    @Column(name = "GENERAL_SURGICAL_EFFORT", nullable = true, length=1048576)
    private Integer generalSugicalEffort;
    
    @Column(name = "GENERAL_SKINCAR_EFFORT", nullable = true, length=1048576)
    private Integer generalSkinCareEffort;
    
    @Column(name = "GENERAL_DOCTOR_OPERATION_EFFORT", nullable = true, length=1048576)
    private Integer generalDoctorOperationEffort;
    
    @Column(name="DOCTOR_SEQ", nullable=true)
    private Integer doctorSeq;
}
