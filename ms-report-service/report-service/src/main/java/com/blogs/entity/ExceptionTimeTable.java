package com.blogs.entity;

import java.util.Date;

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
@Table(name = "ExceptionTimeTable")
@NamedQuery(name = "ExceptionTimeTable.findAll", query = "SELECT m FROM ExceptionTimeTable m")
public class ExceptionTimeTable extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name="CODE", nullable=false)
    private String code;
    
    @Column(name="DOCTOR_ID", nullable=false)
    private Integer doctorId;
    
    @Column(name="BRANCH_ID", nullable=false)
    private Integer branchId;
    
    @Column(name="DATE", nullable=false)
    private Date date;
    
    @Column(name="START_TIME", nullable=false)
    private String startTime;
    
    @Column(name="END_TIME", nullable=false)
    private String endTime;
    
    @Column(name="TIME_GAP", nullable=false)
    private Integer timeGap;
    
    @Column(name="CONSULT_FREE_PER_SLOT", nullable=false)
    private Integer consultFreePerSlot;
    
    @Column(name="CONSULT_MAX_PER_SLOT", nullable=false)
    private Integer consultMaxPerSlot;
    
    @Column(name="PROCEDURE_FREE_PER_SLOT", nullable=false)
    private Integer procedureFreePerSlot;
    
    @Column(name="PROCEDURE_MAX_PER_SLOT", nullable=false)
    private Integer procedureMaxPerSlot;
    
    @Column(name="SKINCARE_FREE_PER_SLOT", nullable=false)
    private Integer skincareFreePerSlot;
    
    @Column(name="SKINCARE_MAX_PER_SLOT", nullable=false)
    private Integer skincareMaxPerSlot;
    
    @Column(name="WARRANTY_FREE_PER_SLOT", nullable=false)
    private Integer warrantyFreePerSlot;
    
    @Column(name="WARRANTY_MAX_PER_SLOT", nullable=false)
    private Integer warrantyMaxPerSlot;
    
    @Column(name="FIXING_FREE_PER_SLOT", nullable=false)
    private Integer fixingFreePerSlot;
    
    @Column(name="FIXING_MAX_PER_SLOT", nullable=false)
    private Integer fixingMaxPerSlot;
    
    @Column(name="FOLLOW_UP_FREE_PER_SLOT", nullable=false)
    private Integer followUpFreePerSlot;
    
    @Column(name="FOLLOW_UP_MAX_PER_SLOT", nullable=false)
    private Integer followUpMaxPerSlot;
}
