/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestModel<T extends Object> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T criteria;
    
    @ApiModelProperty(notes = "size", example = "10")
    private Integer size;
    
    @ApiModelProperty(notes = "page", example = "0")
    private Integer page;
    
    @ApiModelProperty(notes = "eventTimeStamp", example = "2022-03-07 17:34:00")
    private String eventTimeStamp;
    
    @ApiModelProperty(notes = "timezone", example = "Asia/Bangkok")
    private String timezone;
    
}
