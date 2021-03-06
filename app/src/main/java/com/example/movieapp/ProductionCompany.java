
package com.example.movieapp;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ProductionCompany implements Serializable
{

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("logo_path")
    @Expose
    private Object logoPath;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("origin_country")
    @Expose
    private String originCountry;
    private final static long serialVersionUID = 778663544912314879L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductionCompany() {
    }

    /**
     * 
     * @param logoPath
     * @param name
     * @param originCountry
     * @param id
     */
    public ProductionCompany(long id, Object logoPath, String name, String originCountry) {
        super();
        this.id = id;
        this.logoPath = logoPath;
        this.name = name;
        this.originCountry = originCountry;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Object getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(Object logoPath) {
        this.logoPath = logoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

}
