package com.something.runners.api.count;

import org.junit.runner.RunWith;

import com.something.runners.basetest.CucumberApiTest;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith( Cucumber.class )
@CucumberOptions( format = { "json:target/count_movies.json", "html:target/count_movies" },
                features = { "classpath:features/count.feature" },
                tags = { "@count_movies" } )

public class Run_Movies_Count_Test
                extends CucumberApiTest
{
}
