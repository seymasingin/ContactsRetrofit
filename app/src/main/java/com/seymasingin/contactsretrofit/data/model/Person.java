package com.seymasingin.contactsretrofit.data.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Person implements Serializable {

    @SerializedName("kisi_id")
    private int person_id;

    @SerializedName("kisi_ad")
    private String person_name;

    @SerializedName("kisi_tel")
    private String person_tel;

    public Person() {
    }

    public Person(int person_id, @NonNull String person_name, @NonNull String person_tel) {
        this.person_id = person_id;
        this.person_name = person_name;
        this.person_tel = person_tel;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public void setPerson_name(@NonNull String person_name) {
        this.person_name = person_name;
    }

    public void setPerson_tel(@NonNull String person_tel) {
        this.person_tel = person_tel;
    }

    public int getPerson_id() {
        return person_id;
    }

    @NonNull
    public String getPerson_name() {
        return person_name;
    }

    @NonNull
    public String getPerson_tel() {
        return person_tel;
    }
}
