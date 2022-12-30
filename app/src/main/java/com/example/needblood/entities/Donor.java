package com.example.needblood.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "donor_table")
public class Donor {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String name;
    private String city;
    private String bloodGroup;

    public Donor(String name, String city, String bloodGroup) {
        this.name = name;
        this.city = city;
        this.bloodGroup = bloodGroup;
    }


    @NonNull
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
