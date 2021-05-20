package com.vaccine.notifier.vaccinenotifier.entities;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class StateResponse {
    @SerializedName("states")
    private List<State> states;
    @SerializedName("ttl")
    private int ttl;
   
    public int getTtl() {
        return ttl;
    }
    public void setTtl(int ttl) {
        this.ttl = ttl;
    }
    public List<State> getStates() {
        return states;
    }
    public void setStates(List<State> states) {
        this.states = states;
    }

}
