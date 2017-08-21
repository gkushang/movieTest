package com.something.utils;

/**
 * Created by kgajjar on 8/21/17.
 */

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;

public class Properties
{
    private JSONObject jsonObject;

    public Properties()
    {
    }

    public void parse( String env )
                    throws IOException, ParseException
    {
        String filename = "env/" + env + ".json";

        JSONParser parser = new JSONParser();

        Object obj = parser.parse( new FileReader( new ClassPathResource( filename ).getFile().getAbsolutePath() ) );

        this.jsonObject = (JSONObject) obj;
    }

    public Object get( String key )
    {
        return this.jsonObject.get( key );
    }

}
