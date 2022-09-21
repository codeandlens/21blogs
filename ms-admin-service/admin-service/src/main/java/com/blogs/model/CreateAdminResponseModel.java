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
public class CreateAdminResponseModel {
    
    private String adminName;
    

}
