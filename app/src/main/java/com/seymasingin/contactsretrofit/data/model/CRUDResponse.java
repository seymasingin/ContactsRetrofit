package com.seymasingin.contactsretrofit.data.model;

import com.google.gson.annotations.SerializedName;

public class CRUDResponse {
    @SerializedName("success")
    private  int success;

    @SerializedName("message")
    private String message;

    public CRUDResponse(int success, String message) {
        this.success = success;
        this.message = message;
    }

    public CRUDResponse() {
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
