package com.something.api.movie.restclient;

import java.text.MessageFormat;

import com.something.api.movie.domain.Movie;
import com.something.lib.RestClient;
import com.something.lib.RestClientException;
import com.something.utils.Properties;

public class MoviesRestClient
{
    private final RestClient restClient;

    private final Properties properties;

    public MoviesRestClient( Properties properties, RestClient restClient )
    {
        this.restClient = restClient;
        this.properties = properties;
    }

    public Movie getMovie( int id )
                    throws RestClientException
    {
        String url = MessageFormat.format( (String) properties.get( "host" ), id );

        return restClient.httpGet( url, Movie.class );
    }

}
