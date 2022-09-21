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
    @ApiModelProperty(notes = "Sort By", example = "1")
    private String sortBy;
    @ApiModelProperty(notes = "Search By Name", example = "true")
    private Boolean isByName;
    @ApiModelProperty(notes = "Search By Citizen ID", example = "false")
    private Boolean isByNid;
    @ApiModelProperty(notes = "Search By Phone No", example = "false")
    private Boolean isByPhoneNo;
    @ApiModelProperty(notes = "Search By Address", example = "false")
    private Boolean isByAddress;
    @ApiModelProperty(notes = "Admin Id", example = "1")
    private Integer adminId;
}
