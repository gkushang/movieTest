package com.something.guice.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.something.api.restclient.MoviesRestClient;
import com.something._shared_lib.CustomRestClient;
import com.something.utils.Properties;

public class MoviesRestClientProvider
                implements Provider<MoviesRestClient>
{

    private final Properties properties;

    private final CustomRestClient customRestClient;

    @Inject
    public MoviesRestClientProvider( Properties properties, CustomRestClient customRestClient )
    {

        this.properties = properties;
        this.customRestClient = customRestClient;
    }

    @Override
    public MoviesRestClient get()
    {
        return new MoviesRestClient( properties, customRestClient );
    }
}
