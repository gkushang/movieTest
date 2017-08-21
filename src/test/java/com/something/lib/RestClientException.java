package com.something.lib;

public class RestClientException
                extends Exception
{

    public RestClientException()
    {
        super();
    }

    public RestClientException( Exception e )
    {
        super( e );
    }

    public RestClientException( String message )
    {
        super( message );
    }

    public RestClientException( String message, Exception e )
    {
        super( message, e );
    }
}
