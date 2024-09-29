package com.example.loginregisterusingrestapi.backend;

import java.util.Map;
import java.util.List;

public class RegisterRequest {
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private String role;
    private String businessName;
    private String informalName;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private String registrationProof;
    private Map<String, List<String>> businessHours;
    private String deviceToken;
    private String type;
    private String socialId;

    // Getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getInformalName() {
        return informalName;
    }

    public void setInformalName(String informalName) {
        this.informalName = informalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getRegistrationProof() {
        return registrationProof;
    }

    public void setRegistrationProof(String registrationProof) {
        this.registrationProof = registrationProof;
    }

    public Map<String, List<String>> getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(Map<String, List<String>> businessHours) {
        this.businessHours = businessHours;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }
}
