package com.blogs.model;

import java.util.List;

import com.blogs.entity.Booking;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class UploadSchedulerResponseModel {

    @ApiModelProperty(notes = "New Affected flag", example = "Y", required = true)
    private String newAffectedBookingFlag;
    @ApiModelProperty(notes = "List of affected booking", example = "[]", required = false)
    private List<AffectedBookingModel> affectedBookingList;
    @ApiModelProperty(notes = "List of backup booking", example = "[]", required = false)
    private List<Booking> backupBooking;
    
}
