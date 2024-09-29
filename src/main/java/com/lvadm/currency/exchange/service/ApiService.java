package com.lvadm.currency.exchange.service;

import com.lvadm.currency.exchange.exception.InternalHttpClientErrorException;
import com.lvadm.currency.exchange.exception.InternalHttpServerErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ApiService {


    private final String apiKey;
    private final RestTemplate restTemplate;

    @Autowired
    public ApiService(RestTemplate restTemplate, @Value("${application.currency.exchange.api.key}") String apiKey) {
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
    }

    public <V, S> ResponseEntity<V> callApiEndpoint(String url, HttpMethod httpMethod, HttpHeaders headers,
                                                           S body, Class<V> responseType) throws InternalHttpClientErrorException, InternalHttpServerErrorException {
        return callApiEndpoint(url, httpMethod, headers, body, ParameterizedTypeReference.forType(responseType));
    }

    public <V, S> ResponseEntity<V> callApiEndpoint(String url, HttpMethod httpMethod, HttpHeaders headers,
                                                           S body, ParameterizedTypeReference<V> responseType)
            throws InternalHttpClientErrorException, InternalHttpServerErrorException {


        ResponseEntity<V> response = null;

        HttpEntity<S> request = new HttpEntity<>(body, headers);

        try {
            long start = System.currentTimeMillis();
            response = restTemplate.exchange(url, httpMethod, request, responseType);
            long end = System.currentTimeMillis();
            long time = end - start;
            log.info("Request to endpoint {} took {} ms with response code {}",
                    url,
                    time,
                    response.getStatusCode());

        } catch (HttpClientErrorException clientErrorException) {
            throw new InternalHttpClientErrorException(clientErrorException);
        } catch (HttpServerErrorException serverErrorException) {
            throw new InternalHttpServerErrorException(serverErrorException);
        }

        return response;
    }


}
