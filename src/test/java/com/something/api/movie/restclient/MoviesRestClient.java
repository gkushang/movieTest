package com.something.api.movie.restclient;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.util.UriComponentsBuilder;

import com.something._shared_lib.CustomRestClient;
import com.something._shared_lib.CustomRestClientException;
import com.something.api.movie.domain.Movie;
import com.something.utils.Properties;

public class MoviesRestClient
{
    private final CustomRestClient customRestClient;

    private final Properties properties;

    private Logger LOG = Logger.getLogger( MoviesRestClient.class );

    public MoviesRestClient( Properties properties, CustomRestClient customRestClient )
    {
        this.customRestClient = customRestClient;
        this.properties = properties;
    }

    public Movie getMovieById( int id )
                    throws CustomRestClientException
    {
        String url = MessageFormat.format( (String) properties.get( "host" ), id );

        return customRestClient.httpGet( url, Movie.class );
    }

    public Movie[] searchMoviesBy( Map<String, Object> requestParams )
                    throws CustomRestClientException
    {
        return customRestClient.httpGet( _buildUrlWithQueryParams( requestParams ), Movie[].class, requestParams );
    }

    private String _buildUrlWithQueryParams( Map<String, Object> requestParams )
    {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl( _buildUrl() );

        LOG.info( "requestParams: " + requestParams );

        Iterator it = requestParams.entrySet().iterator();

        while ( it.hasNext() )
        {
            Map.Entry pair = (Map.Entry) it.next();

            builder.queryParam( (String) pair.getKey(), pair.getValue() );

            it.remove();
        }

        return builder.build().encode().toUriString();
    }

    private String _buildUrl()
    {
        String url = (String) properties.get( "host" );

        LOG.info( "url: " + url );

        return url;
    }

    public Movie[] getMovies()
                    throws CustomRestClientException
    {
        String url = _buildUrl();
        return customRestClient.httpGet( url, Movie[].class );
    }

}
