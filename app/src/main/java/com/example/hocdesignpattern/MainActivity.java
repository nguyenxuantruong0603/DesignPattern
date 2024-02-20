package com.example.hocdesignpattern;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hocdesignpattern.observer.Wage;
import com.example.hocdesignpattern.observer.notifiers.LxVoDoi;
import com.example.hocdesignpattern.observer.notifiers.Shopee;
import com.example.hocdesignpattern.observer.notifiers.TikTok;
import com.example.hocdesignpattern.observer.notifiers.TruongNx;
import com.example.hocdesignpattern.singleton.TypeTwo;
import com.google.android.flexbox.FlexboxLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        demoObserver();
        demoMultiThreading();
        FlexboxLayout flexboxLayout = findViewById(R.id.fl_demo);

        for (int i = 0; i < 8; i++) {
            TextView textView = new TextView(this);
            textView.setText("ahihi do ngok 12312" + i);
            flexboxLayout.addView(textView);
        }
    }

    private void demoMultiThreading() {
        Thread thread = new Thread(() -> new Handler(Looper.getMainLooper()).postDelayed(() -> {
            TypeTwo typeThree2 = TypeTwo.getInstance();
            Log.e("check", String.valueOf(TypeTwo.getCountInstance()));
        }, 100));
        thread.start();

        Thread thread2 = new Thread(() -> new Handler(Looper.getMainLooper()).postDelayed(() -> {
            TypeTwo typeThree = TypeTwo.getInstance();
            Log.e("check1", String.valueOf(TypeTwo.getCountInstance()));
        }, 100));
        thread2.start();

        Thread thread3 = new Thread(() -> new Handler(Looper.getMainLooper()).postDelayed(() -> {
            TypeTwo typeThree = TypeTwo.getInstance();
            Log.e("check2", String.valueOf(TypeTwo.getCountInstance()));
        }, 100));
        thread3.start();
    }

    private void demoObserver() {
        Wage wage = new Wage();

        TruongNx truongNx = new TruongNx(wage);
        TikTok tikTok = new TikTok(wage);
        LxVoDoi lxVoDoi = new LxVoDoi(wage);

        wage.setThuongThem(1000000);
        Log.e("hihi", "xoa thang LX");
        wage.removeEmployee(lxVoDoi);
        wage.setDefaultWage(5500000);
        Log.e("hihi", "xoa them thang truongNx");
        wage.removeEmployee(truongNx);
        Log.e("hihi", "add them thang shopee");
        Shopee shopee = new Shopee(wage);
        wage.payWage();
    }
}