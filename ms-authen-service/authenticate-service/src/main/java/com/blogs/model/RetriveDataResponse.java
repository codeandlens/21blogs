/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Retrive data from broker")
public class RetriveDataResponse {

	private String event;
    private Object data;
    
}
