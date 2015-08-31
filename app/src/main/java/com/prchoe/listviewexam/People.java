package com.prchoe.listviewexam;

/**
 * Created by massivCode on 2015-08-31.
 */
public class People {

    private String name;
    private String phoneNumber;
    private int imageResourceId;

    public People() {
    }

    public People(String name, String phoneNumber, int imageResourceId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.imageResourceId = imageResourceId;
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
