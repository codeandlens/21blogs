package com.blogs.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class SendMessageLineRequestModel {
    
    @ApiModelProperty(notes = "to", example = "U48fc9b5203651a7910a8b25bb52a08ac")
    private String to;
    @ApiModelProperty(notes = "message List")
    private List<MessageModel> messages;

}
