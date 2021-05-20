package com.vaccine.notifier.vaccinenotifier.entities;

import com.google.gson.annotations.SerializedName;

public class District {
    @SerializedName("district_id")
    private int id;
    @SerializedName("state_id")
    private int stateId;
    @SerializedName("district_name")
    private String districtName;
    @SerializedName("district_name_1")
    private String districtName1;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getStateId() {
        return stateId;
    }
    public void setStateId(int stateId) {
        this.stateId = stateId;
    }
    public String getDistrictName() {
        return districtName;
    }
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    public String getDistrictName1() {
        return districtName1;
    }
    public void setDistrictName1(String districtName1) {
        this.districtName1 = districtName1;
    }
    
}
