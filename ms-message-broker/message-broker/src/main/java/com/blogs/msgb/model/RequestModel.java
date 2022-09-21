/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.msgb.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

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
    private Integer size;
    private Integer page;
    
}
