package com.example.PincodeDistanceAPI.model;

import jakarta.persistence.Lob;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pincode {
    @Id
    private String pincode;
    private Double latitude;
    private Double longitude;

    @Lob
    private String polygon; // Optional field for polygon data

    // Getters and Setters

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPolygon() {
        return polygon;
    }

    public void setPolygon(String polygon) {
        this.polygon = polygon;
    }
}
