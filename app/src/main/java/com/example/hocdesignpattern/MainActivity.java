package com.example.hocdesignpattern;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hocdesignpattern.model.UserModel;
import com.example.hocdesignpattern.observer.Wage;
import com.example.hocdesignpattern.observer.notifiers.LxVoDoi;
import com.example.hocdesignpattern.observer.notifiers.Shopee;
import com.example.hocdesignpattern.observer.notifiers.TikTok;
import com.example.hocdesignpattern.observer.notifiers.TruongNx;
import com.example.hocdesignpattern.realmutils.RealmUtils;
import com.example.hocdesignpattern.singleton.TypeTwo;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        demoObserver();
        demoMultiThreading();
        TextView tv = findViewById(R.id.tvdemo);
        Button btn_add = findViewById(R.id.btn_add);
        Button btn_update = findViewById(R.id.btn_update);
        Button btn_delete = findViewById(R.id.btn_delete);
        Button btn_getAll = findViewById(R.id.btn_getAll);

        tv.setSelected(true);
        tv.setText("Nguyen Xuan Truong Nguyen Xuan Truong Nguyen Xuan Truong");
        UserModel userModel = new UserModel();
        userModel.setName("Xuân Trường");
        userModel.setAge(26);
        userModel.setAddress("Liên Bạt - Ứng Hòa - Hà Nội");
        userModel.setPhoneNumber("0396036610");

        btn_add.setOnClickListener(v -> {
            RealmUtils.getInstance().addUserToRealm(userModel);
        });

        btn_getAll.setOnClickListener(v -> {
            Log.e("checkGetAll", RealmUtils.getInstance().readUserFromRealm().toString());

        });

        btn_update.setOnClickListener(v -> {


        });

        btn_delete.setOnClickListener(v -> {
            RealmUtils.getInstance().deleteAllUserByName("Xuân Trường 1");
        });

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