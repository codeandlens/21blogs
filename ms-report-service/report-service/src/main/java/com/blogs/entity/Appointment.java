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
@Table(name = "Appointment")
@NamedQuery(name = "Appointment.findAll", query = "SELECT m FROM Appointment m")
public class Appointment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name="APPOINTMENT_TYPE", nullable=false)
    private String appointmentType;
    
    @Column(name="APPOINTMENT_TYPE_NAME_TH", nullable=true)
    private String appointmentTypeNameTh;
    
    @Column(name="APPOINTMENT_TYPE_NAME_EN", nullable=true)
    private String appointmentTypeNameEn;
    
    @Column(name="CONTINUOUS_FLAG", nullable=true)
    private String continuousFlag;
    
    @Column(name="BOOKING_TYPE", nullable=true)
    private String bookingType;
    
    @Column(name="MEDICAL_LICENSE", nullable=true)
    private String medicalLicense;
    
    @Column(name="SERVICE_CLASS", nullable=true)
    private String serviceClass;
    
    @Column(name="MIN_DAY", nullable=true)
    private Integer minDay;
    
    @Column(name="WARRANTY_PERIOD_DAY", nullable=true)
    private Integer warrantyPeriodDay;
    
    @Column(name="NEED_PAYMENT", nullable=true)
    private String needPayment;

}