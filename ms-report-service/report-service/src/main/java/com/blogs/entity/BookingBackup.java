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
@Table(name = "BookingBackup")
@NamedQuery(name = "BookingBackup.findAll", query = "SELECT m FROM BookingBackup m")
public class BookingBackup extends BaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name="REFERENCE_CODE", nullable=true)
    private String referenceCode;
    
    @Column(name="DOCTOR_ID", nullable=true)
    private Integer doctorId;
    
    @Column(name="DOCTOR_NAME_EN", nullable=true)
    private String doctorNameEn;
    
    @Column(name="DOCTOR_NAME_TH", nullable=true)
    private String doctorNameTh;
    
    @Column(name="BRANCH_ID", nullable=true)
    private Integer branchId;
    
    @Column(name="BRANCH_NAME", nullable=true)
    private String branchName;
    
    @Column(name="BOOKING_DATE", nullable=true)
    private Date bookingDate;
    
    @Column(name="START_TIME", nullable=true)
    private String startTime;
    
    @Column(name="END_TIME", nullable=true)
    private String endTime;
    
    @Column(name="ARRAIVE_TIME", nullable=true)
    private String arraiveTime;
    
    @Column(name="CUSTOMER_ID", nullable=false)
    private Integer customerId;
    
    @Column(name="CUSTOMER_NAME", nullable=false)
    private String customerName;
    
    @Column(name="APPOINTMENT_TYPE", nullable=true)
    private String appointmentType;
    
    @Column(name="SERVICE_CLASS", nullable=true)
    private String serviceClass;
    
    @Column(name="BOOKING_TYPE", nullable=false)
    private String bookingType;
    
    @Column(name="REMARK", nullable=true)
    private String remark;
    
    @Column(name="BOOKING_STATUS" , nullable=true) 
    private String bookingStatus;
    
    @Column(name="ARRANGEMENT_ID", nullable=true)
    private Integer arrangementId;
    
    @Column(name="BOOKING_CODE", nullable=true)
    private String bookingCode;
    
    @Column(name="QUESTIONNAIRE_ID", nullable=true)
    private Integer questionnaireId;
    
    
    @Column(name="SERVICE_STATUS", nullable=true)
    private String serviceStatus;
    
    @Column(name="REF_BOOKING_ID", nullable=true)
    private Integer refBookingId;
    
    @Column(name="PAYMENT_FLAG", nullable=true)
    private String paymentFlag;
    
    @Column(name="PAYMENT_VALIDATION_FLAG", nullable=true)
    private String paymentValidationFlag;
    
    @Column(name="PAYMENT_VALIDATE_TIMESTAMP",nullable=true)
    private Date paymentValidateTimestamp;
    
    @Column(name="EDITABLE_FLAG", nullable=true)
    private String editableFlag;
    
    @Column(name="CANCELABLE_FLAG", nullable=true)
    private String cancelableFlag;
    

    @Column(name="PAYMENT_AMOUNT", nullable=true)
    private Integer paymentAmount;
    
    @Column(name="PAYMENT_TIME",nullable=true)
    private Date paymentTime;
    
    @Column(name="PAYMENT_UPLOAD_SLIP_FLAG", nullable=true)
    private String paymentUploadSlipFlag;
    
    @Column(name="PAYMENT_BANK_NAME", nullable=true)
    private String paymentBankName;

}
