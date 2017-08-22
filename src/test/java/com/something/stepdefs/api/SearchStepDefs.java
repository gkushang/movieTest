package com.something.stepdefs.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;
import com.something.api.movie.domain.Movie;
import com.something.api.movie.restclient.MoviesRestClient;
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

    @Given( "^Fred creates the library with (\\d+) movies$" )
    public void fred_creates_the_library_with_movies( int numberOfMovies )
                    throws Throwable
    {
        Thread.sleep( 4000 );
    }

    @When( "^he counts total number of movies$" )
    public void he_counts_total_number_of_movies()
                    throws Throwable
    {
    }

    @Then( "^he gets (\\d+) count$" )
    public void he_gets_count( int numberOfMovies )
                    throws Throwable
    {
        int count = moviesRestClient.getMovies().length;
        assertThat( "count is not equal", count, is( numberOfMovies ) );
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

    @Then( "^he gets \"(.*?)\" movies only$" )
    public void he_gets_movies_only( int numberOfMovies )
                    throws Throwable
    {
        assertThat( "number of movies are incorrect", movies.length, is( numberOfMovies ) );
    }

}
