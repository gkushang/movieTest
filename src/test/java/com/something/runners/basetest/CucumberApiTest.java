package com.something.runners.basetest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith( Cucumber.class )
@CucumberOptions( format = { "pretty" },
                glue = "com.something.stepdefs.api",
                strict = false,
                tags = { "~@wip" } )

public abstract class CucumberApiTest
{
}
