/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
@ApiModel(description = "Proke subscribe request Model")
public class CheckingAndRetriveRequest {

	String serviceName;
	String lastDataTimeStamp;
	
}
