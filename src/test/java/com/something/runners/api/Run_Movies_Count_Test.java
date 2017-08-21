package com.something.runners.api;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import com.something.runners.basetest.CucumberApiTest;

@RunWith( Cucumber.class )
@CucumberOptions( format = { "json:target/count_movies.json", "html:target/count_movies" },
                features = { "classpath:features/search.feature" },
                tags = { "@count_movies" } )

public class Run_Movies_Count_Test
                extends CucumberApiTest
{
}
