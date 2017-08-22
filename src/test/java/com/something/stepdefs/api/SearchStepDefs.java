package com.something.stepdefs.api;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;
import com.something.api.domain.Movie;
import com.something.api.restclient.MoviesRestClient;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class SearchStepDefs
{
    private final MoviesRestClient moviesRestClient;

    private Movie[] movies;

    @Inject
    public SearchStepDefs( MoviesRestClient moviesRestClient )
    {
        this.moviesRestClient = moviesRestClient;
    }

    @Given( "^movie library has (\\d+) entries of \"(.*?)\" movie$" )
    public void movie_library_has_entries_of_movie( int numberOfMovies, String movieName )
                    throws Throwable
    {
        Thread.sleep( 4000 );
    }

    @When( "^Fred searches for the \"(.*?)\" movie$" )
    public void fred_searches_for_the_movie( String movieName )
                    throws Throwable
    {
        Map<String, Object> requestParams = new HashMap<>();
        requestParams.put( "name", movieName );

        movies = moviesRestClient.searchMoviesBy( requestParams );
    }

}
