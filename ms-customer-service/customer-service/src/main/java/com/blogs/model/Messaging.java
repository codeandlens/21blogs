/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class Messaging {
    RecipientFbMessageModel recipient;
    RecipientFbMessageModel sender;
    Long timestamp;
    RecipientFbMessageModel optin;
    
}
