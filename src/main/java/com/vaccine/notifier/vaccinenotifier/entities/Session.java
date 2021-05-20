package com.vaccine.notifier.vaccinenotifier.entities;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Session {
    @SerializedName("center_id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("address")
    private String address;
    @SerializedName("state_name")
    private String stateName;
    @SerializedName("district_name")
    private String districtName;
    @SerializedName("block_name")
    private String blockName;
    @SerializedName("pincode")
    private Integer pinCode;
    @SerializedName("from")
    private String fromTime;
    @SerializedName("to")
    private String toTime;
    @SerializedName("lat")
    private Double lattitude;
    @SerializedName("long")
    private Double longitude;
    @SerializedName("fee_type")
    private String feeType;
    @SerializedName("session_id")
    private String sessionId;
    @SerializedName("date")
    private String date;
    @SerializedName("available_capacity_dose1")
    private Integer availableCapacityDose1;
    @SerializedName("available_capacity_dose2")
    private Integer availableCapacityDose2;
    @SerializedName("available_capacity")
    private Integer availableCapacity;
    @SerializedName("fee")
    private String fee;
    @SerializedName("min_age_limit")
    private Integer minimumAgeLimit;
    @SerializedName("vaccine")
    private String vaccineName;
    @SerializedName("slots")
    private List<String> slots;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getDistrictName() {
        return districtName;
    }
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    public String getBlockName() {
        return blockName;
    }
    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }
    public Integer getPinCode() {
        return pinCode;
    }
    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }
    public String getFromTime() {
        return fromTime;
    }
    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }
    public String getToTime() {
        return toTime;
    }
    public void setToTime(String toTime) {
        this.toTime = toTime;
    }
    public Double getLattitude() {
        return lattitude;
    }
    public void setLattitude(Double lattitude) {
        this.lattitude = lattitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public String getFeeType() {
        return feeType;
    }
    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }
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
    public Integer getAvailableCapacityDose1() {
        return availableCapacityDose1;
    }
    public void setAvailableCapacityDose1(Integer availableCapacityDose1) {
        this.availableCapacityDose1 = availableCapacityDose1;
    }
    public Integer getAvailableCapacityDose2() {
        return availableCapacityDose2;
    }
    public void setAvailableCapacityDose2(Integer availableCapacityDose2) {
        this.availableCapacityDose2 = availableCapacityDose2;
    }
    public Integer getAvailableCapacity() {
        return availableCapacity;
    }
    public void setAvailableCapacity(Integer availableCapacity) {
        this.availableCapacity = availableCapacity;
    }
    public String getFee() {
        return fee;
    }
    public void setFee(String fee) {
        this.fee = fee;
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
