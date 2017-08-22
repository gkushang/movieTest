package com.something.guice.providers;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.google.inject.Provider;
import com.something._shared_lib.CustomRestClient;

public class RestClientProvider
                implements Provider<CustomRestClient>
{

    @Override
    public CustomRestClient get()
    {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add( "Accept", "application/json" );

        return new CustomRestClient(headers);
    }
}
