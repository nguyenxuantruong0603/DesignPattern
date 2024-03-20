package com.example.hocdesignpattern;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("TruongNxDemo")
                .schemaVersion(1)
                .allowWritesOnUiThread(true)
                .allowQueriesOnUiThread(true)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
