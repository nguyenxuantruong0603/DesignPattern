package com.example.hocdesignpattern.observer;

public class Wage extends SubjectObserver {

    private int defaultWage = 5200000;

    private int thuongThem = 0;

    public int getDefaultWage() {
        return defaultWage;
    }

    public void setDefaultWage(int defaultWage) {
        this.defaultWage = defaultWage;
        changeWage(defaultWage);
    }

    public int getThuongThem() {
        return thuongThem;
    }

    public void setThuongThem(int thuongThem) {
        this.thuongThem = thuongThem;

    }

    private void changeWage(int newWage){
        notifyWageChange(newWage);
    }
}
