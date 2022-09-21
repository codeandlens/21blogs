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
public class AddressModel {
    
    @ApiModelProperty(notes = "Address ID", example = "1")
    private Integer id;
    
    @ApiModelProperty(notes = "Address Info", example = "12/1")
    private String addressInfo;
    
    @ApiModelProperty(notes = "Province ID", example = "1")
    private Integer provinceId;
    
    @ApiModelProperty(notes = "Province Code", example = "1")
    private String provinceCode;
    
    @ApiModelProperty(notes = "Province Name", example = "1")
    private String provinceName;
    
    @ApiModelProperty(notes = "District ID", example = "1")
    private Integer districtId;
    
    @ApiModelProperty(notes = "District Code", example = "1")
    private String districtCode;
    
    @ApiModelProperty(notes = "District Name", example = "1")
    private String districtName;
    
    @ApiModelProperty(notes = "Sub District ID", example = "1")
    private Integer subDistrictId;
    
    @ApiModelProperty(notes = "Sub District Code", example = "1")
    private String subDistrictCode;
    
    @ApiModelProperty(notes = "Sub District Name", example = "1")
    private String subDistrictName;
    
    @ApiModelProperty(notes = "Post Code", example = "1")
    private String postCode;
}
