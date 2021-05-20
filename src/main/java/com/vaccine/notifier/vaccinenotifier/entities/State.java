package com.vaccine.notifier.vaccinenotifier.entities;

import com.google.gson.annotations.SerializedName;

public class State {
    
    @SerializedName("state_id")
    private int id;
    @SerializedName("state_name")
    private String stateName;
    @SerializedName("state_name_1")
    private String stateName1;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getStateName1() {
        return stateName1;
    }
    public void setStateName1(String stateName1) {
        this.stateName1 = stateName1;
    }

}
