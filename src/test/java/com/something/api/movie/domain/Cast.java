package com.something.api.movie.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "actor"
})
public class Cast {

    @JsonProperty("actor")
    private Actor actor;

    @JsonProperty("actor")
    public Actor getActor() {
        return actor;
    }

    @JsonProperty("actor")
    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(actor).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Cast) == false) {
            return false;
        }
        Cast rhs = ((Cast) other);
        return new EqualsBuilder().append(actor, rhs.actor).isEquals();
    }

}
