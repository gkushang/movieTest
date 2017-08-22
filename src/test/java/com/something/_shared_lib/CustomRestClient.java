package com.something._shared_lib;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class CustomRestClient
{
    private final RestTemplate restTemplate;

    private MultiValueMap<String, String> header;

    private Map<String, Object> requestParameters = new HashMap<>();

    private Logger LOG = Logger.getLogger( CustomRestClient.class );

    public CustomRestClient( MultiValueMap<String, String> header )
    {
        this.header = header;
        restTemplate = new RestTemplate();
    }

    public <T> T httpGet( String url, Class<T> cls )
                    throws CustomRestClientException
    {
        final HttpEntity<T> request = new HttpEntity<>( this.header );
        ResponseEntity response = this.rest( url, HttpMethod.GET, request, cls );
        return (T) response.getBody();
    }

    public <T> T httpGet( String url, Class<T> cls, Map<String, Object> requestParameters )
                    throws CustomRestClientException
    {
        this.requestParameters = requestParameters;
        return this.httpGet( url, cls );
    }

    private <T> ResponseEntity rest( String url, HttpMethod method, HttpEntity<T> request, Class cls )
                    throws CustomRestClientException
    {
        LOG.info( "requestParameters: " + requestParameters );

        return requestParameters.isEmpty() ?
                        this.restTemplate.exchange( url, method, request, cls ) :
                        this.restTemplate.exchange( url, method, request, cls, requestParameters );
    }

}
