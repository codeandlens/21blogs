package com.blogs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class RecipientFbMessageModel {

    @ApiModelProperty(notes = "login Id", example = "login Id")
    private String login_id;
    
    @ApiModelProperty(notes = "Sender Id", example = "Sender Id")
    private String id;

}
