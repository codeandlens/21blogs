/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class CustomerDetailModel {

    @ApiModelProperty(notes = "Customer ID", example = "1")
    private Integer id;
    
    @ApiModelProperty(notes = "User Name", example = "Woottipong.s")
    private String username;
    
    @ApiModelProperty(notes = "Password", example = "123456")
    private String password;

    @ApiModelProperty(notes = "Customer First Name", example = "Woottipong")
    private String firstName;

    @ApiModelProperty(notes = "Customer Last Name", example = "Saowayong")
    private String lastName;

    @ApiModelProperty(notes = "Nick Name", example = "Chivas")
    private String nickName;

//    @ApiModelProperty(notes = "Citizen ID", example = "1209700326666")
//    private String citizenId;

    @ApiModelProperty(notes = "Email", example = "woottipongs@gmail.com")
    private String email;

    @ApiModelProperty(notes = "Gender", example = "Male")
    private String gender;

    @ApiModelProperty(notes = "Photo", example = "BASE64")
    private String photo;

    @ApiModelProperty(notes = "Customer status", example = "Active")
    private String status;

    @ApiModelProperty(notes = "Customer Tel No.", example = "0825555555")
    private String telNo;
    
    @ApiModelProperty(notes = "Note", example = "REMARK")
    private String note;
    

    
   
    
    
}
