package com.example.mcdbfproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Activity2 extends Activity {
    EditText x1, x2, x3, x6, x7;
    String User_FName, User_LName, User_date, User_Age, User_ID_number, User_Username, User_password;
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        x1 = (EditText) findViewById(R.id.FName);
        x2 = (EditText) findViewById(R.id.LName);
        x3 = (EditText) findViewById(R.id.date);
        x6 = (EditText) findViewById(R.id.username);
        x7 = (EditText) findViewById(R.id.Password);

    }

    public void userReg(View view) {
        User_FName = x1.getText().toString();
        User_LName = x2.getText().toString();
        User_date = x3.getText().toString();
        User_Username = x6.getText().toString();
        User_password = x7.getText().toString();
        String method = "register";
        ConnectionHelper connectionHelper = new ConnectionHelper(this);
        connectionHelper.execute(method, User_FName, User_FName, User_date, User_Username, User_password);
        finish();

    }
    public void userLogin(View view)
    {
        EditText x1, x6, x7;
        String User_FName, User_LName, User_date, User_Age, User_ID_number, User_Username, User_password;
        x1 = (EditText) findViewById(R.id.FName);
        x6 = (EditText) findViewById(R.id.username);
        x7 = (EditText) findViewById(R.id.Password);



        User_FName = x1.getText().toString();
        User_Username = x6.getText().toString();
        User_password = x7.getText().toString();
        String method = "Login";
        ConnectionHelper connectionHelper = new ConnectionHelper(this);
        connectionHelper.execute(method, User_FName, User_Username, User_password);
        finish();

    }

}


