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
public class MessageModel {
    @ApiModelProperty(notes = "type", example = "text")
    private String type;
    @ApiModelProperty(notes = "text", example = "Message You want to send")
    private String text;
}
