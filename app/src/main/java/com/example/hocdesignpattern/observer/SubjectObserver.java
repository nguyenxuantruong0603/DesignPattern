package com.example.hocdesignpattern.observer;

import java.util.ArrayList;

public class SubjectObserver {
    private final ArrayList<Observer> observerList = new ArrayList<>();

    public void addEmployee(Observer observer) {
        observerList.add(observer);
    }

    public void removeEmployee(Observer observer) {
        observerList.remove(observer);
    }

    public void payWage() {
        for (Observer observer : observerList) {
            observer.payWage();
        }
    }

    public void notifyWageChange(int newWage) {
        for (Observer observer : observerList) {
            observer.notifyWageChange(newWage);
        }
    }
}
