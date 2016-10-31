package com.example.realmdatabaseexample;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {

   private RealmConfiguration config;
   @Override
    public void onCreate() {
        super.onCreate();
       config = new RealmConfiguration.Builder(this).build();
       Realm.setDefaultConfiguration(config);


    }


}
