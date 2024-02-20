package com.example.hocdesignpattern.singleton;

import android.util.Log;

/**
 * Cách này có thể giúp cho class chỉ có một Instance duy nhất
 * kể cả trong môi trường đa luồng.
 * Nhưng khi lần đầu khởi tạo nó có thể ảnh hưởng 1 chút tới hiệu năng
 * vì sử dụng synchronized
 */
public class TypeThree {
    private static volatile TypeThree instance;
    public static Integer count = 0;

    private TypeThree() {

    }

    public static Integer getCountInstance(){
        return count;
    }

    public static TypeThree getInstance() {
        if (null == instance) {
            synchronized (TypeThree.class) {
                if (null == instance) {
                    Log.e("checkInstance", "instance");
                    instance = new TypeThree();
                    count += 1;
                }
            }
        }
        return instance;
    }

}
