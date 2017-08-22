package com.something.api.restclient;

import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.util.UriComponentsBuilder;

import com.something._shared_lib.CustomRestClient;
import com.something._shared_lib.CustomRestClientException;
import com.something.api.domain.Movie;
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

    public Movie[] searchMoviesBy( Map<String, Object> requestParams )
                    throws CustomRestClientException
    {
        String url = _buildUrlWithQueryParams( requestParams );

        return customRestClient.httpGet( url, Movie[].class );
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
        return customRestClient.httpGet( _buildUrl(), Movie[].class );
    }

    public Movie insertMovie()
                    throws CustomRestClientException
    {
        Movie movie = new Movie();

        //        movie.setName( "Sultan" );
        movie.setId( 1100 );

        return customRestClient.httpPost( _buildUrl(), movie );
    }

}
