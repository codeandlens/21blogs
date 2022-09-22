/**
 * @author 21Bolgs
 * Woottipong.S
 */
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
@NamedQuery(name = "CustomerDetail.findAll", query = "SELECT c FROM CustomerDetail c")
public class CustomerDetail extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column(name = "USERNAME", nullable = true, unique = true)
    private String username;
    
    @Column(name = "PASSWORD", nullable = true, unique = true)
    private String password;
    
    @Column(name = "EMAIL", nullable = true)
    private String email;

    @Column(name = "FIRST_NAME", nullable = true)
    private String firstName;
    
    @Column(name = "LAST_NAME", nullable = true)
    private String lastName;
    
    @Column(name = "NICK_NAME", nullable = true)
    private String nickName;

    @Column(name = "GENDER", nullable = true)
    private String gender;
    
    @Column(name = "TEL_NO", nullable = true)
    private String telNo;
    
    @Lob
    @Column(name = "PHOTO", nullable = true, length=1048576)
    private String photo;

    @Column(name = "REGISTER_DATE", nullable = true)
    private String registerDate;
    
    @Column(name = "STATUS", nullable = true)
    private String status;
    
    @Column(name = "NOTE", nullable = true)
    private String note;
    

    
}
