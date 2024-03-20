package com.example.hocdesignpattern.realmutils;

import android.util.Log;

import com.example.hocdesignpattern.model.UserModel;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmUtils {
    private static RealmUtils instance;
    private static Realm realm;

    private RealmUtils() {
    }

    public static RealmUtils getInstance() {
        if (null == instance) {
            instance = new RealmUtils();
            realm = Realm.getDefaultInstance();
        }

        return instance;
    }

    public void addUserToRealm(UserModel userModel) {
        realm.beginTransaction();
        userModel.addToRealm(realm.createObject(UserModel.class));
        realm.commitTransaction();
    }

    public void updateUser(UserModel userModel) {

    }

    public void deleteUserByName(String name) {
        UserModel userModel = realm.where(UserModel.class).equalTo("name", name).findFirst();
        if (null != userModel) {
            try {
                Realm.Transaction transaction = realm1 -> userModel.deleteFromRealm();
                realm.executeTransaction(transaction);
                Log.e("realm", "remove thanh cong");
            } catch (Exception e) {
                Log.e("ErrorRealm", e.getMessage() +" ");
            }
        } else {
            Log.e("ErrorRealm", "khong tim thay User " + name);
        }
    }

    public void deleteAllUserByName(String name) {
        RealmResults<UserModel> userModel = realm.where(UserModel.class).equalTo("name", name).findAll();
        if (null != userModel) {
            try {
                Realm.Transaction transaction = realm1 -> userModel.deleteAllFromRealm();
                realm.executeTransaction(transaction);
                Log.e("realm", "remove thanh cong");
            } catch (Exception e) {
                Log.e("ErrorRealm", e.getMessage() +" ");
            }
        } else {
            Log.e("ErrorRealm", "khong tim thay User " + name);
        }
    }

    public ArrayList<UserModel> readUserFromRealm() {
        RealmResults<UserModel> results = realm.where(UserModel.class).findAll();

        return new ArrayList<>(realm.copyFromRealm(results));
    }


}
