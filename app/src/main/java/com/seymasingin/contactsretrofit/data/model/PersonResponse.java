package com.seymasingin.contactsretrofit.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonResponse {
    @SerializedName("kisiler")
    private List<Person> contacts;

    @SerializedName("success")
    private int success;

    public PersonResponse(List<Person> kisiler, int success) {
        this.contacts = kisiler;
        this.success = success;
    }

    public PersonResponse() {
    }

    public List<Person> getKisiler() {
        return contacts;
    }

    public int getSuccess() {
        return success;
    }

    public void setKisiler(List<Person> kisiler) {
        this.contacts = kisiler;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
