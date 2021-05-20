package com.vaccine.notifier.vaccinenotifier.entities;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SlotForWeek {
    @SerializedName("session_id")
    private String sessionId;
    @SerializedName("date")
    private String date;
    @SerializedName("available_capacity")
    private Integer availableCapacity;
    @SerializedName("min_age_limit")
    private Integer minimumAgeLimit;
    @SerializedName("vaccine")
    private String vaccineName;
    @SerializedName("slots")
    private List<String> slots;

    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Integer getAvailableCapacity() {
        return availableCapacity;
    }
    public void setAvailableCapacity(Integer availableCapacity) {
        this.availableCapacity = availableCapacity;
    }
    public Integer getMinimumAgeLimit() {
        return minimumAgeLimit;
    }
    public void setMinimumAgeLimit(Integer minimumAgeLimit) {
        this.minimumAgeLimit = minimumAgeLimit;
    }
    public String getVaccineName() {
        return vaccineName;
    }
    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
    public List<String> getSlots() {
        return slots;
    }
    public void setSlots(List<String> slots) {
        this.slots = slots;
    }
    
}
