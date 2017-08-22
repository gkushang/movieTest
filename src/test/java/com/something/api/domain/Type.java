package com.something.api.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonPropertyOrder( { "type" } )
public class Type
{

    @JsonProperty( "type" )
    private String type;

    @JsonProperty( "type" )
    public String getType()
    {
        return type;
    }

    @JsonProperty( "type" )
    public void setType( String type )
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toStringExclude( this, new String[] { "" } );
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder().append( type ).toHashCode();
    }

    @Override
    public boolean equals( Object other )
    {
        if ( other == this )
        {
            return true;
        }
        if ( ( other instanceof Type ) == false )
        {
            return false;
        }
        Type rhs = ( (Type) other );
        return new EqualsBuilder().append( type, rhs.type ).isEquals();
    }

}
