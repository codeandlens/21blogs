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
@Table(name = "STG_LEAVE")
@NamedQuery(name = "StgLeave.findAll", query = "SELECT p FROM StgLeave p")
public class StgLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name="LEAVE_DATE", nullable=true)
    private Date leaveDate;
    
    @Column(name="EXCHANGE_DATE", nullable=true)
    private Date exchangeDate;
    
    @Column(name="EXCHANGE_BRANCH_ID", nullable=true)
    private Integer exchangeBranchId;
    
    @Column(name="DOCTOR_ID", nullable=false)
    private Integer doctorId;
    
    @Column(name="START_TIME", nullable=true)
    private String startTime;
    
    @Column(name="END_TIME", nullable=true)
    private String endTime;
    
    @Column(name="GEN_DOC_OPR_FREE_PER_SLOT", nullable=true)
    private Integer genDocOprFreePerSlot;
    
    @Column(name="GEN_DOC_OPR_MAX_PER_SLOT", nullable=true)
    private Integer genDocOprMaxPerSlot;
    
    @Column(name="GEN_SKIN_FREE_PER_SLOT", nullable=true)
    private Integer genSkinFreePerSlot;
    
    @Column(name="GEN_SKIN_MAX_PER_SLOT", nullable=true)
    private Integer genSkinMaxPerSlot;
    
    @Column(name="GEN_SUR_FREE_PER_SLOT", nullable=true)
    private Integer genSurFreePerSlot;
    
    @Column(name="GEN_SUR_MAX_PER_SLOT", nullable=true)
    private Integer genSurMaxPerSlot;
    
    @Column(name="LEAVE_TYPE", nullable=true)
    private String leaveType;
    
}
