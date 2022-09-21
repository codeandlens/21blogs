package com.blogs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CustomerDetail")
@NamedQuery(name = "CustomerDetail.findAll", query = "SELECT w FROM CustomerDetail w")
public class CustomerDetail extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name = "ARRANGEMENT_ID",nullable = true)
    private Integer arrangementId;
    
    @Column(name = "INVITE_ID", nullable = true)
    private Integer inviteId;
    
    @Column(name = "LATEST_INVITE_DATE", nullable = true)
    private String latestInviteDate;
    
    @Column(name = "NICK_NAME", nullable = true)
    private String nickName;

    @Column(name = "BLOOD_TYPE", nullable = true)
    private String bloodType;

    @Column(name = "CITIZEN_ID", nullable = true, unique = true)
    private String citizenId;

    @Column(name = "DAY_OF_BIRTH", nullable = true)
    private Integer dayOfBirth;

    @Column(name = "EMAIL", nullable = true)
    private String email;

    @Column(name = "ETHNICITY", nullable = true)
    private String ethnicity;

    @Column(name = "FACEBOOK_ID", nullable = true)
    private String facebookId;

    @Column(name = "FIRST_NAME", nullable = true)
    private String firstName;

    @Column(name = "GENDER", nullable = true)
    private String gender;

    @Column(name = "HN_NUMBER", nullable = true)
    private String hnNumber;

    @Column(name = "LAST_NAME", nullable = true)
    private String lastName;

    @Column(name = "LASTEST_OFFER_DATE", nullable = true)
    private String lastestOfferDate;

    @Column(name = "LINE_ID", nullable = true)
    private String lineId;

    @Column(name = "MONTH_OF_BIRTH", nullable = true)
    private int monthOfBirth;

    @Column(name = "NATIONALITY", nullable = true)
    private String nationality;

    @Column(name = "OCCUPATION", nullable = true)
    private String occupation;
    
    @Lob
    @Column(name = "PHOTO", nullable = true, length=1048576)
    private String photo;

    @Column(name = "REGISTER_DATE", nullable = true)
    private String registerDate;

    @Column(name = "RELIGION", nullable = true)
    private String religion;

    @Column(name = "STATUS", nullable = true)
    private String status;

    @Column(name = "TEL_NO", nullable = true)
    private String telNo;

    @Column(name = "TEL_NO_EXT", nullable = true)
    private String telNoExt;

    @Column(name = "YEAR_OF_BIRTH", nullable = true)
    private Integer yearOfBirth;
    
    @Column(name = "PARENT_NAME", nullable = true)
    private String parentName;
    
    @Column(name = "PARENT_TEL_NO", nullable = true)
    private String parentTelNo;
    
    @Column(name = "NOTE", nullable = true)
    private String note;
    
    @Column(name = "PARENT_TEL_NO_EXT", nullable = true)
    private String parentTelNoExt;
    
    @Column(name = "MARITAL_STATUS", nullable = true)
    private String maritalStatus;
    
    @Column(name = "ADMIN_ID", nullable = true)
    private Integer adminId;
    
    @Column(name = "ADMIN_NAME", nullable = true)
    private String adminName;
    
    @Column(name = "FB_LOGIN_ID", nullable = true)
    private String fbLoginId;
    
    @Column(name = "FB_PS_ID", nullable = true)
    private String fbPsId;
}
