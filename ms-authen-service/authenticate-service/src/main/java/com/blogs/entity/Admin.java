/**
 * @author 21Bolgs
 * Woottipong.S
 */
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
@Table(name = "Admin")
@NamedQuery(name = "Admin.findAll", query = "SELECT u FROM Admin u")
public class Admin extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ADMINID", unique = true, nullable = false)
    private Integer adminId;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ROLE_NAME", nullable = true)
    private String roleName;
    
    @Column(name = "FULL_NAME", nullable = true)
    private String fullName;
    
    @Column(name = "FULL_NAME_EN", nullable = true)
    private String fullNameEn;
    
}
