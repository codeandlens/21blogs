/**
 * @author bustlesoft.com
 * woottipong
 * 
 */
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
@Table(name = "DoctorBranch")
@NamedQuery(name = "DoctorBranch.findAll", query = "SELECT m FROM DoctorBranch m")
public class DoctorBranch extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "DOCTOR_ID", nullable = false)
    private Integer doctorId;

    @Column(name = "BRANCH_ID", nullable = false)
    private Integer branchId;

//    @Column(name = "BRANCH_NAME_TH", nullable = false)
//    private String branchNameTh;
//
//    @Column(name = "BRANCH_NAME_EN", nullable = true)
//    private String branchNameEn;

}
