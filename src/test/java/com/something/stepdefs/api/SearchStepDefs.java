package com.something.stepdefs.api;

import com.google.inject.Inject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.something.api.movie.restclient.MoviesRestClient;
import com.something.utils.Properties;

public class SearchStepDefs
{
    private final Properties properties;

    private final MoviesRestClient moviesRestClient;

    @Inject
    public SearchStepDefs( Properties properties, MoviesRestClient moviesRestClient )
    {
        this.properties = properties;
        this.moviesRestClient = moviesRestClient;
    }

    @Given( "^Fred creates the library with (\\d+) movies$" )
    public void fred_creates_the_library_with_movies( int numberOfMovies )
                    throws Throwable
    {
        System.out.println( "Name: ===>>>>>>>> " + moviesRestClient.getMovie( 1 ).getName() );
    }

    @When( "^he counts total number of movies$" )
    public void he_counts_total_number_of_movies()
                    throws Throwable
    {
    }

    @Then( "^he gets (\\d+) count$" )
    public void he_gets_count( int arg1 )
                    throws Throwable
    {
    }

}
