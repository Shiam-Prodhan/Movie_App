
package com.example.movieapp;

import java.io.Serializable;
import java.util.List;;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CastResponse implements Serializable
{

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("cast")
    @Expose
    private List<Cast> cast = null;
    @SerializedName("crew")
    @Expose
    private List<Crew> crew = null;
    private final static long serialVersionUID = -2157922483300016539L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CastResponse() {
    }

    /**
     * 
     * @param cast
     * @param id
     * @param crew
     */
    public CastResponse(long id, List<Cast> cast, List<Crew> crew) {
        super();
        this.id = id;
        this.cast = cast;
        this.crew = crew;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }

}
