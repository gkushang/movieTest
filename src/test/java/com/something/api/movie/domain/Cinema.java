package com.something.api.movie.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cast"
})
public class Cinema {

    @JsonProperty("cast")
    private Cast cast;

    @JsonProperty("cast")
    public Cast getCast() {
        return cast;
    }

    @JsonProperty("cast")
    public void setCast(Cast cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cast).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Cinema) == false) {
            return false;
        }
        Cinema rhs = ((Cinema) other);
        return new EqualsBuilder().append(cast, rhs.cast).isEquals();
    }

}
