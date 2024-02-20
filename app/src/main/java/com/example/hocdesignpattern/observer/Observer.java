package com.example.hocdesignpattern.observer;

public abstract class Observer {

    protected SubjectObserver subjectObserver;
    public abstract void payWage();
    public abstract void notifyWageChange(Integer wage);
}
