package com.something.runners.api.search;

import org.junit.runner.RunWith;

import com.something.runners.basetest.CucumberApiTest;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith( Cucumber.class )
@CucumberOptions( format = { "json:target/search_multiple_movies.json", "html:target/search_multiple_movies" },
                features = { "classpath:features/search.feature" },
                tags = { "@search_multiple_movies" } )

public class Run_Movies_Search_Multiple_Movie_Test
                extends CucumberApiTest
{
}
