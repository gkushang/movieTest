package com.something.lib;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Multimap;

public class RestClient
{
    private final RestTemplate restTemplate;

    private MultiValueMap<String, String> header;

    private Multimap<Object, Object> requestParameters;

    public RestClient( MultiValueMap header )
    {
        this.header = header;
        restTemplate = new RestTemplate();
    }

    public <T> T httpGet( String url, Class<T> cls )
                    throws RestClientException
    {
        final HttpEntity<T> request = new HttpEntity<>( this.header );
        return this.rest( url, HttpMethod.GET, request, cls ).getBody();
    }

    private <T> ResponseEntity<T> rest( String url, HttpMethod method, HttpEntity<T> request, Class cls )
                    throws RestClientException
    {
        ResponseEntity response;

        //            if ( requestParameters.isEmpty() )
        response = this.restTemplate.exchange( url, method, request, cls );
        //            else
        //                response = this.restTemplate.exchange( url, method, request, cls, requestParameters );

        return response;
    }

}
