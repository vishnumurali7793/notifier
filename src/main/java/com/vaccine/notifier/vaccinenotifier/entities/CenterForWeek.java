package com.vaccine.notifier.vaccinenotifier.entities;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CenterForWeek {
    @SerializedName("center_id")
    private Integer id;
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
    @SerializedName("lat")
    private Double lattitude;
    @SerializedName("long")
    private Double longitude;
    @SerializedName("from")
    private String fromTime;
    @SerializedName("to")
    private String toTime;
    @SerializedName("fee_type")
    private String feeType;
    @SerializedName("sessions")
    private List<SlotForWeek> sessions;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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
    public String getFeeType() {
        return feeType;
    }
    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }
    public List<SlotForWeek> getSessions() {
        return sessions;
    }
    public void setSessions(List<SlotForWeek> sessions) {
        this.sessions = sessions;
    }
    
}
