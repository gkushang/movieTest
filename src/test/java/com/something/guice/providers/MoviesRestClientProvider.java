package com.something.guice.providers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.something.api.movie.restclient.MoviesRestClient;
import com.something.lib.RestClient;
import com.something.utils.Properties;

public class MoviesRestClientProvider
                implements Provider<MoviesRestClient>
{

    private final Properties properties;

    private final RestClient restClient;

    @Inject
    public MoviesRestClientProvider( Properties properties, RestClient restClient )
    {

        this.properties = properties;
        this.restClient = restClient;
    }

    @Override
    public MoviesRestClient get()
    {
        return new MoviesRestClient( properties, restClient );
    }
}
