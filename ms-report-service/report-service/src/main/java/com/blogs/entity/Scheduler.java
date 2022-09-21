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
@Table(name = "Scheduler")
@NamedQuery(name = "Scheduler.findAll", query = "SELECT m FROM Scheduler m")
public class Scheduler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name = "SCHEDULER_CODE", nullable = false)
    private String schedulerCode;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    private Date endDate;
    
    @Column(name = "DOCTOR_ID", nullable = false)
    private Integer doctorId;

}
