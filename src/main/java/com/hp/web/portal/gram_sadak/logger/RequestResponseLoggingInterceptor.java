package com.hp.web.portal.gram_sadak.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestResponseLoggingInterceptor.class);


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("===========================request begin================================================");
            LOGGER.debug("URI         : {}", request.getURI());
            LOGGER.debug("Method      : {}", request.getMethod());
            LOGGER.debug("Headers     : {}", request.getHeaders());
            LOGGER.debug("Request body: {}", new String(body, "UTF-8"));
            LOGGER.debug("==========================request end================================================");
        }
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("============================response begin==========================================");
            LOGGER.debug("Status code  : {}", response.getStatusCode());
            LOGGER.debug("Status text  : {}", response.getStatusText());
            LOGGER.debug("Headers      : {}", response.getHeaders());
            LOGGER.debug("Response body: {}", StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
            LOGGER.debug("=======================response end=================================================");
        }
    }
}

