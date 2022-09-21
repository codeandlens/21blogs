/**
 * @author 21Bolgs
 * Woottipong.S
 */

package com.blogs.utils;

import java.io.IOException;
import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
	return (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR || httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
	log.error("Async " + method.name() + " Request for : \"" + url + "\" RESPONSE STASTUS : " + response.getStatusCode() + " (" + response.getStatusText()
		+ "); invoking error handler");
	ResponseErrorHandler.super.handleError(url, method, response);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {

	if (httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
	    // handle SERVER_ERROR
	    log.error("HTTP SERVER_ERROR : \t" + httpResponse.getStatusCode());
	} else if (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
	    // handle CLIENT_ERROR
	    log.error("HTTP CLIENT_ERROR : \t" + httpResponse.getStatusCode());
	    if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
		// throw new NotFoundException();
	    }
	}
    }

}
