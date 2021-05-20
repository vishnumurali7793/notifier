package com.vaccine.notifier.vaccinenotifier.entities;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CenterResponse {
    @SerializedName("centers")
    private List<CenterForWeek> centers;

    public List<CenterForWeek> getCenters() {
        return centers;
    }

    public void setCenters(List<CenterForWeek> centers) {
        this.centers = centers;
    }
    
}
