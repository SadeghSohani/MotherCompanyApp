package com.example.mothercompanyapp;

import com.google.gson.annotations.SerializedName;

public class RequestBody {
    @SerializedName("chickensCount")
    private Integer chickensCount;
    public RequestBody(Integer chickensCount) {
        this.chickensCount = chickensCount;
    }
}
