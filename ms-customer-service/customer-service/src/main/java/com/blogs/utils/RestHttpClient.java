/**
 * @author 21Bolgs
 * Woottipong.S
 */
package com.blogs.utils;

import java.util.Arrays;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestHttpClient {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public <T extends Object> ResponseEntity<T> httpGet(String url, ParameterizedTypeReference<T> responseType)
	    throws Exception {
	try {
	    CloseableHttpClient httpClient = HttpClients.custom()
		    .setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build())
		    .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();

	    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
	    requestFactory.setHttpClient(httpClient);

	    RestTemplate restTemplate = new RestTemplate(requestFactory);
//		    restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
	    return restTemplate.exchange(url, HttpMethod.GET, null, responseType);
	} catch (Exception e) {
	    log.error(e.getMessage(), e);
	    throw new Exception(e);
	}

    }

    public <T extends Object> ResponseEntity<T> httpPost(String url, Object params,
	    ParameterizedTypeReference<T> responseType) throws Exception {

	try {

	    CloseableHttpClient httpClient = HttpClients.custom()
		    .setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build())
		    .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();

	    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

	    requestFactory.setHttpClient(httpClient);
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<Object> entity = new HttpEntity<Object>(params, headers);
	    RestTemplate restTemplate = new RestTemplate(requestFactory);
//		    restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
	    return restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
	} catch (Exception e) {
	    log.error(e.getMessage(), e);
	    throw new Exception(e);
	}

    }

    public <T extends Object> ResponseEntity<T> httpPostWithToken(String url, Object params,
	    ParameterizedTypeReference<T> responseType, String token) throws Exception {

	try {

	    CloseableHttpClient httpClient = HttpClients.custom()
		    .setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build())
		    .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();

	    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

	    requestFactory.setHttpClient(httpClient);
	    HttpHeaders headers = new HttpHeaders();
	    if (token != null) {
		headers.set("Authorization", token);
	    }
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<Object> entity = new HttpEntity<Object>(params, headers);
	    RestTemplate restTemplate = new RestTemplate(requestFactory);
//		    restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
	    return restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
	} catch (Exception e) {
	    log.error(e.getMessage(), e);
	    throw new Exception(e);
	}

    }

    public <T extends Object> ResponseEntity<T> httpPostWithLineToken(String url, Object params,
	    ParameterizedTypeReference<T> responseType, String token) throws Exception {

	try {

	    CloseableHttpClient httpClient = HttpClients.custom()
		    .setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build())
		    .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build();

	    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

	    requestFactory.setHttpClient(httpClient);
	    HttpHeaders headers = new HttpHeaders();
	    if (token != null) {
		headers.set("Authorization", "Bearer " + token);
	    }
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<Object> entity = new HttpEntity<Object>(params, headers);
	    RestTemplate restTemplate = new RestTemplate(requestFactory);
	    restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
	    return restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
	} catch (Exception e) {
	    log.error(e.getMessage(), e);
	    throw e;
	}

    }
}
