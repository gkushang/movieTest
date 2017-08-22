package com.something._shared_lib;

public class CustomRestClientException
                extends Exception
{

    public CustomRestClientException()
    {
        super();
    }

    public CustomRestClientException( Exception e )
    {
        super( e );
    }

    public CustomRestClientException( String message )
    {
        super( message );
    }

    public CustomRestClientException( String message, Exception e )
    {
        super( message, e );
    }
}
