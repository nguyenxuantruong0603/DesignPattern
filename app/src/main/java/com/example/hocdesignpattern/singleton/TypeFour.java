package com.example.hocdesignpattern.singleton;


import android.util.Log;

/**
 * Cách này có thể giúp cho class chỉ có một Instance duy nhất
 * kể cả trong môi trường đa luồng.
 * Nhưng do phương thức getInstance() được đồng bộ hóa khiến cho nhiều
 * luồng không thể truy cập cùng 1 thời điểm.
 * Nên khi sử dụng đa luồng hiệu năng có thể bị giảm đi 1 chút
 * */
public class TypeFour {
    private static TypeFour instance;

    private TypeFour() {

    }

    synchronized public static TypeFour getInstance() {
        if (null == instance) {
            Log.e("checkInstance","instance");
            instance = new TypeFour();
        }
        return instance;
    }
}
