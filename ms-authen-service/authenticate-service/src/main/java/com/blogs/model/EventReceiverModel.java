/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class EventReceiverModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String event;
    private Object data;
    
}
