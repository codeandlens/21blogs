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
@Table(name = "STG_STANDARD")
@NamedQuery(name = "StgStandard.findAll", query = "SELECT p FROM StgStandard p")
public class StgStandard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name="SCHEDULER_DATE", nullable=false)
    private Date schedulerDate;
    
    @Column(name="BRANCH_ID", nullable=false)
    private Integer branchId;
    
    @Column(name="DOCTOR_ID", nullable=false)
    private Integer doctorId;
    
    @Column(name="DOCTOR_NAME", nullable=false)
    private String doctorName;
    
}
