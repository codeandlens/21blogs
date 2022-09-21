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
public class GenerateTokenRequestModel {
    
    @ApiModelProperty(notes = "Username (CITIZEN ID )", example = "admin")
    private String username;
    
    @ApiModelProperty(notes = "Password (Birth Date )", example = "P@ssw0rd")
    private String password;

}
