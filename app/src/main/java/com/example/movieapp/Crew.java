
package com.example.movieapp;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Crew implements Serializable
{

    @SerializedName("adult")
    @Expose
    private boolean adult;
    @SerializedName("gender")
    @Expose
    private long gender;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("known_for_department")
    @Expose
    private String knownForDepartment;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("original_name")
    @Expose
    private String originalName;
    @SerializedName("popularity")
    @Expose
    private double popularity;
    @SerializedName("profile_path")
    @Expose
    private Object profilePath;
    @SerializedName("credit_id")
    @Expose
    private String creditId;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("job")
    @Expose
    private String job;
    private final static long serialVersionUID = 3372978459260677192L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Crew() {
    }

    /**
     * 
     * @param originalName
     * @param creditId
     * @param gender
     * @param popularity
     * @param name
     * @param id
     * @param knownForDepartment
     * @param profilePath
     * @param adult
     * @param department
     * @param job
     */
    public Crew(boolean adult, long gender, long id, String knownForDepartment, String name, String originalName, double popularity, Object profilePath, String creditId, String department, String job) {
        super();
        this.adult = adult;
        this.gender = gender;
        this.id = id;
        this.knownForDepartment = knownForDepartment;
        this.name = name;
        this.originalName = originalName;
        this.popularity = popularity;
        this.profilePath = profilePath;
        this.creditId = creditId;
        this.department = department;
        this.job = job;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKnownForDepartment() {
        return knownForDepartment;
    }

    public void setKnownForDepartment(String knownForDepartment) {
        this.knownForDepartment = knownForDepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public Object getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(Object profilePath) {
        this.profilePath = profilePath;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
