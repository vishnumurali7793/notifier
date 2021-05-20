package com.vaccine.notifier.vaccinenotifier.entities;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DistrictResponse {
    @SerializedName("districts")
    private List<District> districts;
    @SerializedName("ttl")
    private int ttl;

    public List<District> getDistricts() {
        return districts;
    }
    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
    public int getTtl() {
        return ttl;
    }
    public void setTtl(int ttl) {
        this.ttl = ttl;
    }
    
}
