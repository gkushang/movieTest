package com.something.runners.api.search;

import org.junit.runner.RunWith;

import com.something.runners.basetest.CucumberApiTest;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith( Cucumber.class )
@CucumberOptions( format = { "json:target/search_one_movie.json", "html:target/search_one_movie" },
                features = { "classpath:features/search.feature" },
                tags = { "@search_one_movie" } )

public class Run_Movies_Search_One_Movie_Test
                extends CucumberApiTest
{
}
