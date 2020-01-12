package com.example.technical.loginwithrememberme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editUser;
    EditText editPass;
    CheckBox check;
    Button btn;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPass= (EditText) findViewById(R.id.editpass);
        editUser= (EditText) findViewById(R.id.edituser);
        btn= (Button) findViewById(R.id.btn);
        check= (CheckBox) findViewById(R.id.check);
        load();
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("nameSharedPref",0);
                editor=sharedPreferences.edit();
                editor.putString("username",editUser.getText().toString());
                editor.putString("password",editPass.getText().toString());
                editor.putBoolean("chk",b);
                editor.commit();

                }else{
                    SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("nameSharedPref",0);
                    editor=sharedPreferences.edit();
                    editor.putString("username","");
                    editor.putString("password","");
                    editor.putBoolean("chk",false);
                    editor.commit();
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("nameSharedPref",0);
                editor=sharedPreferences.edit();
                editor.putString("username",editUser.getText().toString());
                editor.putString("password",editPass.getText().toString());
                editor.commit();
                Intent i =new Intent(MainActivity.this,ListView.class);
                startActivity(i);
            }
        });
    }

    public void load(){
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("nameSharedPref",0);
        String name=sharedPreferences.getString("username","");
        String pass=sharedPreferences.getString("password","");
        Boolean chk=sharedPreferences.getBoolean("chk",false);
        editUser.setText(name);
        editPass.setText(pass);
        check.setChecked(chk);
    }
}
