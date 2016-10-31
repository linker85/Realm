package com.example.realmdatabaseexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.realmdatabaseexample.controller.PrimaryKeyFactory;
import com.example.realmdatabaseexample.controller.RealmController;
import com.example.realmdatabaseexample.model.Person;

import java.util.List;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG_";
    private Realm realm;

    private RealmController realmController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        realmController = new RealmController(realm);
        PrimaryKeyFactory.getInstance().initialize(realm);

        realmController.addData("fname", "lname", "contact");

        realmController.updatePerson(1, "fname2", "lname", "contact");

        List<Person> person = realmController.getAllData();

        Log.d(TAG, "onCreate: " + person.get(0).getContact());

        if (person != null && !person.isEmpty()) {
            realmController.deleteById(person.get(0).getId());
        }

    }

}
