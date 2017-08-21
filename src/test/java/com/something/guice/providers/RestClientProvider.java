package com.something.guice.providers;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.google.inject.Provider;
import com.something.lib.RestClient;

public class RestClientProvider
                implements Provider<RestClient>
{

    @Override
    public RestClient get()
    {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add( "Accept", "application/json" );

        return new RestClient(headers);
    }
}
