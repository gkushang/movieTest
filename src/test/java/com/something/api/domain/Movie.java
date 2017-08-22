package com.something.api.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( { "id", "name", "director", "type", "music", "cinema", "logo", "rating" } )
public class Movie
{

    @JsonProperty( "id" )
    private Integer id;

    @JsonProperty( "name" )
    private String name;

    @JsonProperty( "director" )
    private String director;

    @JsonProperty( "type" )
    private Type type;

    @JsonProperty( "music" )
    private Music music;

    @JsonProperty( "cinema" )
    private Cinema cinema;

    @JsonProperty( "logo" )
    private Logo logo;

    @JsonProperty( "rating" )
    private Double rating;

    @JsonProperty( "id" )
    public Integer getId()
    {
        return id;
    }

    @JsonProperty( "id" )
    public void setId( Integer id )
    {
        this.id = id;
    }

    @JsonProperty( "name" )
    public String getName()
    {
        return name;
    }

    @JsonProperty( "name" )
    public void setName( String name )
    {
        this.name = name;
    }

    @JsonProperty( "director" )
    public String getDirector()
    {
        return director;
    }

    @JsonProperty( "director" )
    public void setDirector( String director )
    {
        this.director = director;
    }

    @JsonProperty( "type" )
    public Type getType()
    {
        return type;
    }

    @JsonProperty( "type" )
    public void setType( Type type )
    {
        this.type = type;
    }

    @JsonProperty( "music" )
    public Music getMusic()
    {
        return music;
    }

    @JsonProperty( "music" )
    public void setMusic( Music music )
    {
        this.music = music;
    }

    @JsonProperty( "cinema" )
    public Cinema getCinema()
    {
        return cinema;
    }

    @JsonProperty( "cinema" )
    public void setCinema( Cinema cinema )
    {
        this.cinema = cinema;
    }

    @JsonProperty( "logo" )
    public Logo getLogo()
    {
        return logo;
    }

    @JsonProperty( "logo" )
    public void setLogo( Logo logo )
    {
        this.logo = logo;
    }

    @JsonProperty( "rating" )
    public Double getRating()
    {
        return rating;
    }

    @JsonProperty( "rating" )
    public void setRating( Double rating )
    {
        this.rating = rating;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toStringExclude( this, new String[] { "" } );
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder().append( id ).append( name ).append( director ).append( type ).append( music )
                        .append( cinema ).append( logo ).append( rating ).toHashCode();
    }

    @Override
    public boolean equals( Object other )
    {
        if ( other == this )
        {
            return true;
        }
        if ( ( other instanceof Movie ) == false )
        {
            return false;
        }
        Movie rhs = ( (Movie) other );
        return new EqualsBuilder().append( id, rhs.id ).append( name, rhs.name ).append( director, rhs.director )
                        .append( type, rhs.type ).append( music, rhs.music ).append( cinema, rhs.cinema )
                        .append( logo, rhs.logo ).append( rating, rhs.rating ).isEquals();
    }

}
