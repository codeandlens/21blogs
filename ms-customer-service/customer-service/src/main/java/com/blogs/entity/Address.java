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
@Table(name = "Address")
@NamedQuery(name = "Address.findAll", query = "SELECT w FROM Address w")
public class Address extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name = "ADDRESS_INFO", nullable = true)
    private String addressInfo;
    
    @Column(name = "PROVINCE_ID", nullable = true)
    private Integer provinceId;
    
    @Column(name = "PROVINCE_CODE", nullable = true)
    private String provinceCode;
    
    @Column(name = "PROVINCE_NAME", nullable = true)
    private String provinceName;
    
    @Column(name = "DISTRICT_ID", nullable = true)
    private Integer districtId;
    
    @Column(name = "DISTRICT_CODE", nullable = true)
    private String districtCode;
    
    @Column(name = "DISTRICT_NAME", nullable = true)
    private String districtName;
    
    @Column(name = "SUB_DISTRICT_ID", nullable = true)
    private Integer subDistrictId;
    
    @Column(name = "SUB_DISTRICT_CODE", nullable = true)
    private String subDistrictCode;
    
    @Column(name = "SUB_DISTRICT_NAME", nullable = true)
    private String subDistrictName;
    
    @Column(name = "POST_CODE", nullable = true)
    private String postCode;
    
    @Column(name = "CUSTOMER_ID", nullable = true)
    private Integer customerId;
}
