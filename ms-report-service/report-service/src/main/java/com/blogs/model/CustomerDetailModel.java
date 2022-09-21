package com.blogs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class CustomerDetailModel {

    @ApiModelProperty(notes = "Customer ID", example = "1")
    private Integer id;

    @ApiModelProperty(notes = "Photo", example = "")
    private String photo;

    @ApiModelProperty(notes = "Customer First Name", example = "Testy")
    private String firstName;

    @ApiModelProperty(notes = "Customer Last Name", example = "Art")
    private String lastName;

    @ApiModelProperty(notes = "Blood Type", example = "O")
    private String bloodType;

    @ApiModelProperty(notes = "Citizen ID", example = "1209700326666")
    private String citizenId;

    @ApiModelProperty(notes = "Day of Birth", example = "1")
    private Integer dayOfBirth;

    @ApiModelProperty(notes = "Month of Birth", example = "1")
    private int monthOfBirth;

    @ApiModelProperty(notes = "Year of Birth", example = "2022")
    private Integer yearOfBirth;

    @ApiModelProperty(notes = "Email", example = "testy.art@gmail.com")
    private String email;

    @ApiModelProperty(notes = "Ethnicity", example = "Thai")
    private String ethnicity;

    @ApiModelProperty(notes = "Facebook ID", example = "https://www.facebook.com/testy.art")
    private String facebookId;

    @ApiModelProperty(notes = "Gender", example = "Male")
    private String gender;

    @ApiModelProperty(notes = "HN Number", example = "HN:0000000001")
    private String hnNumber;

    @ApiModelProperty(notes = "Lastest Offer Date", example = "01/01/2022")
    private String lastestOfferDate;

    @ApiModelProperty(notes = "Line ID", example = "@testy.art")
    private String lineId;

    @ApiModelProperty(notes = "Nationality", example = "Thai")
    private String nationality;

    @ApiModelProperty(notes = "Occupation", example = "Youtuber")
    private String occupation;

    @ApiModelProperty(notes = "Register Date", example = "01/01/2022")
    private String registerDate;

    @ApiModelProperty(notes = "Religion", example = "Buddhist")
    private String religion;

    @ApiModelProperty(notes = "Customer status", example = "Active")
    private String status;

    @ApiModelProperty(notes = "Customer Tel No.", example = "0825555555")
    private String telNo;

    @ApiModelProperty(notes = "Customer Tel No EXT", example = "004")
    private String telNoExt;
    
    @ApiModelProperty(notes = "Parent Name", example = "Sorapong Chadum")
    private String parentName;
    
    @ApiModelProperty(notes = "Parent Tel No", example = "0888882293")
    private String parentTelNo;
    
    @ApiModelProperty(notes = "Note", example = "REMARK")
    private String note;
    
    @ApiModelProperty(notes = "Parent Tel No EXT", example = "004")
    private String parentTelNoExt;
    
    @ApiModelProperty(notes = "Marital Status", example = "SINGLE")
    private String maritalStatus;
    
    @ApiModelProperty(notes = "Admin ID", example = "1")
    private Integer adminId;
    
    @ApiModelProperty(notes = "Admin Name", example = "Sorapong Chatree")
    private String adminName;
    
    @ApiModelProperty(notes = "Arrangement Id", example = "1")
    private Integer arrangementId;
    
    @ApiModelProperty(notes = "Invite Id", example = "1")
    private Integer inviteId;
    
    @ApiModelProperty(notes = "Lastest Invite Date", example = "01/02/2022")
    private String latestInviteDate;
    
    @ApiModelProperty(notes = "Nick Name", example = "Nick")
    private String nickName;
    
    @ApiModelProperty(notes = "Address")
    private AddressModel address;
    
    @ApiModelProperty(notes = "FaceBook LogIn ID")
    private String fbLoginId;
    
    @ApiModelProperty(notes = "FaceBook PSID")
    private String fbPsId;
    
}
