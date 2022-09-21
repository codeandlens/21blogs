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
@Table(name = "Branch")
@NamedQuery(name = "Branch.findAll", query = "SELECT m FROM Branch m")
public class Branch extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name="BRANCH_CODE", nullable=false)
    private String branchCode;
    
    @Column(name="BRANCH_NAME_TH", nullable=false)
    private String branchNameTh;
    
    @Column(name="BRANCH_NAME_EN", nullable=true)
    private String branchNameEn;
    
    @Column(name="BRANCH_ADDRESS", nullable=true)
    private String branchAddress;
    
    @Column(name="BRANCH_TEL", nullable=true)
    private String branchTel;
    
    @Lob
    @Column(name = "BRANCH_PHOTO", nullable = true, length=1048576)
    private String branchPhoto;
    
    @Column(name="LINK_MAP", nullable=true)
    private String linkMap;
    
    @Lob
    @Column(name = "MAP_PHOTO", nullable = true, length=1048576)
    private String mapPhoto;
    
    @Column(name="TIME_ZONE", nullable=true)
    private String timeZone;
    
    @Column(name="START_OFFICE_HOUR",nullable=true)
    private String startOfficeHour;
    
    @Column(name="END_OFFICE_HOUR",nullable=true)
    private String endOfficeHour;

}
