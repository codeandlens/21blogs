package com.blogs.entity;

import java.io.Serializable;

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
@Table(name = "InviteDetail")
@NamedQuery(name = "InviteDetail.findAll", query = "SELECT w FROM InviteDetail w")
public class InviteDetail extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "CHANNEL", nullable = true)
    private String channel;

    @Column(name = "CUSTOMER_NAME", nullable = true)
    private String customerName;

    @Column(name = "LINK", nullable = true)
    private String link;

    @Column(name = "INVITE_NO", nullable = true)
    private String inviteNo;

    @Column(name = "OTHER_SERVICE_TYPE", nullable = true)
    private String otherServiceType;

    @Column(name = "SERVICE_TYPES", nullable = true)
    private String serviceTypes;

    @Column(name = "STATUS", nullable = true) /* OPEN ACTIVE EXPIRED COMPLETE */
    private String status;

    @Column(name = "INVITE_TYPE", nullable = true) /* OLD NEW */
    private String inviteType;

    @Column(name = "VALID_FROM_DAY", nullable = true)
    private String validFromDay;

    @Column(name = "VALID_FROM_MONTH", nullable = true)
    private String validFromMonth;

    @Column(name = "VALID_FROM_YEAR", nullable = true)
    private String validFromYear;

    @Column(name = "VALID_TO_DAY", nullable = true)
    private String validToDay;

    @Column(name = "VALID_TO_MONTH", nullable = true)
    private String validToMonth;

    @Column(name = "VALID_TO_YEAR", nullable = true)
    private String validToYear;
    
    @Column(name = "CUSTOMER_ID", nullable = true)
    private Integer customerId;
    
    @Column(name = "CREATE_DATE_TIME", nullable = true)
    private String createDateTime;
    
    @Column(name = "LATEST_VIEW_DATE_TIME", nullable = true)
    private String latestViewDateTime;
    
    @Column(name = "FILL_HISTORY_STATUS", nullable = true)
    private String fillHistoryStatus;
    
    @Column(name = "REGISTER_STATUS", nullable = true)
    private String registerStatus;
    
    @Column(name = "ADMIN_ID", nullable = true)
    private Integer adminId;
    
    @Column(name = "ADMIN_NAME", nullable = true)
    private String adminName;
    
    @Column(name = "LATEST_INVITE_DATE_TIME", nullable = true)
    private String latestInviteDateTime;
}
