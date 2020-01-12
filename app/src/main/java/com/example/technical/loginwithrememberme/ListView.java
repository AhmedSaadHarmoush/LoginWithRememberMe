package com.example.technical.loginwithrememberme;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {
    android.widget.ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("nameSharedPref",0);
        String name=sharedPreferences.getString("username","");
        String pass=sharedPreferences.getString("password","");
        ArrayList names=new ArrayList();
        names.add(name);
        ArrayList passwords=new ArrayList();
        passwords.add(pass);
        CustomAdapter adapter=new CustomAdapter(ListView.this, names,passwords );
        lst=(android.widget.ListView)findViewById(R.id.lst);
        lst.setAdapter(adapter);

    }
}
