package com.example.hocdesignpattern.singleton;

import android.util.Log;

/**
 * Cách này được sử dụng nhiều nhất bởi vì tính đơn giản và
 * */

public class TypeOne {

    private TypeOne() {
        Log.e("checkInstance","instance");
    }

    private static class HolderTypeOne {
        static final TypeOne instanceTypeOne = new TypeOne();
    }

    public static TypeOne getInstance() {
        return HolderTypeOne.instanceTypeOne;
    }
}
