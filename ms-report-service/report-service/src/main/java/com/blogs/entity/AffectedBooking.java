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
@Table(name = "AffectedBooking")
@NamedQuery(name = "AffectedBooking.findAll", query = "SELECT m FROM AffectedBooking m")
public class AffectedBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String customerName;

    @Column(name = "CUSTOMER_TEL", nullable = false)
    private String customerTel;
    
    @Column(name = "APPOINTMENT", nullable = false)
    private String appointment;
    
    @Column(name = "DOCTOR_NAME", nullable = false)
    private String doctorName;
    
    @Column(name = "BOOKING_ID", nullable = false)
    private Integer bookingId;

    @Column(name = "BOOKING_CODE", nullable = false)
    private String bookingCode;

    @Column(name = "BOOKING_DATE", nullable = false)
    private Date bookingDate;
    
    @Column(name = "BOOKING_START_TIME", nullable = false)
    private String bookingStartTime;

    @Column(name = "BRANCH_NAME", nullable = false)
    private String branchName;
    
    @Column(name = "NOTIFICATION_FLAG" , nullable=false)
    private String noticficationFlag;

}
