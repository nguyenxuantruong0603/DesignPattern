package com.example.hocdesignpattern.singleton;


/**
 * Cách đơn giản nhất để khởi tạo một Singleton Class
 * nhưng trong môi trường đa luồng vẫn có thể bị khởi tạo nhiều lần
 */
public class TypeTwo {
    private static TypeTwo instance;
    public static Integer countInstance = 0;

    public static Integer getCountInstance() {
        return countInstance;
    }

    private TypeTwo() {
        countInstance += 1;
    }

    public static TypeTwo getInstance() {
        if (null == instance) {
            instance = new TypeTwo();
        }
        return instance;
    }
}
