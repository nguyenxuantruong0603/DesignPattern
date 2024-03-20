package com.example.hocdesignpattern.model;

import io.realm.RealmObject;

public class UserModel extends RealmObject {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UserModel addToRealm(UserModel userModel) {
        userModel.setName(getName());
        userModel.setAge(getAge());
        userModel.setAddress(getAddress());
        userModel.setPhoneNumber(getPhoneNumber());
        return userModel;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
