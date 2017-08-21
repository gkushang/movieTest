package com.something.guice.providers;

import com.google.inject.Provider;
import com.something.utils.Properties;

public class PropertiesProvider
                implements Provider<Properties>
{

    private static final String DEFAULT_ENV = "qa";

    private String testEnv;

    @Override
    public Properties get()
    {
        try
        {
            String env = System.getProperty( "env" );
            testEnv = env != null ? env : DEFAULT_ENV;

            Properties properties = new Properties();
            properties.parse( testEnv );
            return properties;
        }
        catch ( Exception e )
        {
            throw new RuntimeException( "error in processing properties file or env file not found: " + testEnv );
        }
    }
}
