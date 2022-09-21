/**
 * @author bustlesoft.com
 * woottipong
 * 
 */
package com.blogs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PaymentSlip")
@NamedQuery(name = "PaymentSlip.findAll", query = "SELECT p FROM PaymentSlip p")
public class PaymentSlip extends BaseEntity{
    
    
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name="BOOKING_ID", nullable=false)
    private Integer bookingId;
    
    @Lob
    @Column(name="PAYMENT_SLIP", nullable = true, length=1048576)
    private String paymentSlip;
    
    @Column(name="UPLOAD_TIMESTAMP", nullable = true)
    private Date uploadTimestamp;
    
    @Column(name="REMARK", nullable = true)
    private String remark;
    
    @Column(name="PAYMENT_TRANSFER_DATE", nullable = true)
    private String paymentTransferDate;
    
    @Column(name="PAYMENT_TRANSFER_TIME", nullable = true)
    private String paymentTransferTime;
}
