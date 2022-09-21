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
@Table(name = "MedicalLicense")
@NamedQuery(name = "MedicalLicense.findAll", query = "SELECT m FROM MedicalLicense m")
public class MedicalLicense extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name="LICENSE", nullable=true)
    private String license;
    
    @Column(name="MEDICAL_LICENSE_NAME_TH", nullable=true)
    private String medicalLicenseNameTh;
    
    @Column(name="MEDICAL_LICENSE_NAME_EN", nullable=true)
    private String medicalLicenseNameEn;

}
