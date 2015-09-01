package com.prchoe.listviewexam;

import java.io.Serializable;

/**
 * Created by massivCode on 2015-08-31.
 */
public class People implements Serializable{

    private String name;
    private String phoneNumber;
    private int imageResourceId;

    public People() {
    }

    public People(int imageResourceId, String name, String phoneNumber) {
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
