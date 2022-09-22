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
public class CustomerSearchRequestModel {
    @ApiModelProperty(notes = "Search Text", example = "Search String")
    private String searchText;
    @ApiModelProperty(notes = "Search By Name", example = "true")
    private Boolean isByName;
    @ApiModelProperty(notes = "Search By Phone No", example = "false")
    private Boolean isByPhoneNo;
  
}
