package com.blogs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class SendMessageFBRequestModel {
    
    @ApiModelProperty(notes = "recipient")
    private RecipientFbMessageModel recipient;
    
    @ApiModelProperty(notes = "message")
    private MessageModel message;

}
