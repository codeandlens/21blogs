package com.blogs.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class AffectedBookingModel {
    
    @ApiModelProperty(notes = "Customer name", example = "คุณศรัลยา สาคร", required = false)
    private String customerName;
    @ApiModelProperty(notes = "Phone number", example = "0979264919", required = false)
    private String customerTel;
    @ApiModelProperty(notes = "Appointment", example = "ศัลยกรรมจมูก", required = false)
    private String appointment;
    @ApiModelProperty(notes = "Doctor Name", example = "นายแพทย์ XXX", required = false)
    private String doctorName;
    @ApiModelProperty(notes = "booking code", example = "000371-PROCEDURE_NOSE-DR-ANAN-JUNGSUWATTANANON-20220412-TEST-005", required = false)
    private String bookingCode;
    @ApiModelProperty(notes = "booking Date string", example = "20/05/2022", required = false)
    private Date bookingDate;
    @ApiModelProperty(notes = "booking Time string", example = "09:00 น.", required = false)
    private String bookingStartTime;
    @ApiModelProperty(notes = "branch name", example = "อโศก", required = false)
    private String branchName;
    @ApiModelProperty(notes = "Alreay notic", example = "Y", required = false)
    private String alreadyNoticFlag;
    
}
