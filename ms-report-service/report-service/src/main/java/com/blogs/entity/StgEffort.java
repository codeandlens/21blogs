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
@Table(name = "STG_EFFORT")
@NamedQuery(name = "StgEffort.findAll", query = "SELECT p FROM StgEffort p")
public class StgEffort {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name="DOCTOR_ID", nullable=false)
    private Integer doctorId;
    
    @Column(name="GSG_EFFORT", nullable=true)
    private Integer gsgEffort;
    
    @Column(name="GDO_EFFORT", nullable=true)
    private Integer gdoEffort;
    
    @Column(name="GSK_EFFORT", nullable=true)
    private Integer gskEffort;
    
}
