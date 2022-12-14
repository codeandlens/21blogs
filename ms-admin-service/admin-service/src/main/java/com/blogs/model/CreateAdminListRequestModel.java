/**
 * @author bustlesoft.com
 * woottipong
 * 
 */
package com.blogs.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class CreateAdminListRequestModel {
    
    private List<CreateAdminRequestModel> adminList;
    

}
