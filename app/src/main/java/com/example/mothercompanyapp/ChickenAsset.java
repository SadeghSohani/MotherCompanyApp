package com.example.mothercompanyapp;

import com.google.gson.annotations.SerializedName;

public class ChickenAsset {

    @SerializedName("chickenId")
    private String chickenId;
    @SerializedName("chickenFarm")
    private String chickenFarm;
    @SerializedName("feedingCompany")
    private String feedingCompany;
    @SerializedName("motherCompany")
    private String motherCompany;
    @SerializedName("slaughterHouse")
    private String slaughterHouse;
    @SerializedName("owner")
    private String owner;

    public ChickenAsset(
            String chickenId,
            String chickenFarm,
            String feedingCompany,
            String motherCompany,
            String slaughterHouse,
            String owner
    ) {
        this.chickenId = chickenId;
        this.chickenFarm = chickenFarm;
        this.motherCompany = motherCompany;
        this.feedingCompany = feedingCompany;
        this.slaughterHouse = slaughterHouse;
        this.owner = owner;
    }

    public String getChickenId() {
        return chickenId;
    }

    public void setChickenId(String chickenId) {
        this.chickenId = chickenId;
    }

    public String getChickenFarm() {
        return chickenFarm;
    }

    public void setChickenFarm(String chickenFarm) {
        this.chickenFarm = chickenFarm;
    }

    public String getFeedingCompany() {
        return feedingCompany;
    }

    public void setFeedingCompany(String feedingCompany) {
        this.feedingCompany = feedingCompany;
    }

    public String getMotherCompany() {
        return motherCompany;
    }

    public void setMotherCompany(String motherCompany) {
        this.motherCompany = motherCompany;
    }

    public String getSlaughterHouse() {
        return slaughterHouse;
    }

    public void setSlaughterHouse(String slaughterHouse) {
        this.slaughterHouse = slaughterHouse;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
