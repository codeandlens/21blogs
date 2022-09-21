/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(Include.NON_NULL)
public class ResponseModel<T extends Object> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "Response Code", example = "OK", required = true)
    private String code;
    @ApiModelProperty(notes = "Response Descriptions", example = "Success", required = true)
    private String desc;

    private T data;
    private Long totalElements;
    private Integer totalPages;

    public ResponseModel() {
	super();
    }

    public ResponseModel(T data) {
	super();
	this.data = data;
    }

    /**
     * Response Code.
     * 
     * @return String
     */
    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    /**
     * Response Description.
     * 
     * @return
     */
    public String getDesc() {
	return desc;
    }

    public void setDesc(String desc) {
	this.desc = desc;
    }

    public T getData() {
	return data;
    }

    public void setData(T data) {
	this.data = data;
    }

    public Long getTotalElements() {
	return totalElements;
    }

    public void setTotalElements(Long totalElements) {
	this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
	return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
	this.totalPages = totalPages;
    }

}
