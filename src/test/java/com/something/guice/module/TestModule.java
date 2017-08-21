package com.something.guice.module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.something.api.movie.restclient.MoviesRestClient;
import com.something.guice.providers.MoviesRestClientProvider;
import com.something.guice.providers.PropertiesProvider;
import com.something.guice.providers.RestClientProvider;
import com.something.lib.RestClient;
import com.something.utils.Properties;

public class TestModule
                extends AbstractModule
{

    @Override
    protected void configure()
    {
        bind( Properties.class ).toProvider( PropertiesProvider.class ).in( Singleton.class );
        bind( RestClient.class ).toProvider( RestClientProvider.class ).in( Singleton.class );
        bind( MoviesRestClient.class ).toProvider( MoviesRestClientProvider.class ).in( Singleton.class );
    }
}
