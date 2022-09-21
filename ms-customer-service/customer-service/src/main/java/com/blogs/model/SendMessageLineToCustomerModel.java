package com.blogs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class SendMessageLineToCustomerModel {
    @ApiModelProperty(notes = "Customer ID", example = "1")
    private Integer customerId;
    
    @ApiModelProperty(notes = "Message", example = "Test Message")
    private String message;

}
