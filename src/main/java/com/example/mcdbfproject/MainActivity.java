package com.example.mcdbfproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public  void userReg(View view)
    {
        startActivity(new Intent(this,Activity2.class));

    }
    public void userLogin(View view)
    {
        int x =1;
        if(x==1)//data is correct
        startActivity(new Intent(this,Activity3.class));
        else
        startActivity(new Intent(this,Activity2.class));
    }



}