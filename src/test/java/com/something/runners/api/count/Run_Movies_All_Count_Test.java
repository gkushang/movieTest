package com.something.runners.api.count;

import org.junit.runner.RunWith;

import com.something.runners.basetest.CucumberApiTest;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith( Cucumber.class )
@CucumberOptions( format = { "json:target/count_all_movies.json", "html:target/count_all_movies" },
                features = { "classpath:features/count.feature" },
                tags = { "@count_all_movies" } )

public class Run_Movies_All_Count_Test
                extends CucumberApiTest
{
}
