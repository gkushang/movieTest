package com.something.stepdefs.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.inject.Inject;
import com.something.api.domain.Movie;
import com.something.api.restclient.MoviesRestClient;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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
        Thread.sleep( 1000 );
    }

    @When( "^Fred searches for the \"(.*?)\" movie$" )
    public void fred_searches_for_the_movie( String movieName )
                    throws Throwable
    {
        Map<String, Object> requestParams = new HashMap<>();
        requestParams.put( "name", movieName );

        movies = moviesRestClient.searchMoviesBy( requestParams );
    }

    @Then( "^he gets \"(.*?)\" movies from search$" )
    public void he_gets_movies_only( int numberOfMovies )
                    throws Throwable
    {
        System.out.println();
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable( SerializationFeature.INDENT_OUTPUT );
        System.out.println( "\n" + mapper.writeValueAsString( movies[0] ) + "\n" );

        assertThat( "number of movies are incorrect", movies.length, is( numberOfMovies ) );
    }

    @Then( "^he gets \"(.*?)\" movies only$" )
    public void he_gets_movies_only_( int numberOfMovies )
                    throws Throwable
    {
        assertThat( "number of movies are incorrect", movies.length, is( numberOfMovies ) );
    }

}
