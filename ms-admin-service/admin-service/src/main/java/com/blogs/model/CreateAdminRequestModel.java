/**
 * @author bustlesoft.com
 * woottipong
 * 
 */
package com.blogs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class CreateAdminRequestModel {
    
    private String username;
    private String password;
    private String roleName;
    private String fullName;
    private String fullNameEn;   

}
