package com.example.mcdbfproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity3 extends Activity {


    private Button cresta;
    private Button rosebank;
    private Button eastgate;
    private Button sandton;
    private Button northgate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cresta = (Button) findViewById(R.id.button);
        cresta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                atCresta();
            }
        });

        rosebank = (Button) findViewById(R.id.button2);
        rosebank.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                atRosebank();
            }
        });

        sandton = (Button) findViewById(R.id.button4);
        sandton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                atSandton();
            }
        });

        eastgate = (Button) findViewById(R.id.button3);
        eastgate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                atEastgate();
            }
        });

        northgate = (Button) findViewById(R.id.button5);
        northgate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                atNorthgate();
            }
        });
    }

    public void atCresta() {
        Intent SendCresta = new Intent(this, Activity_4.class);
        startActivity(SendCresta);
        final int result =1;
        SendCresta.putExtra("callingActivity", "Cresta");
        startActivity(SendCresta);

    }

    public void atRosebank() {
        Intent SendRosebank = new Intent(this, Activity_4.class);
        startActivity(SendRosebank);
        final int result =1;
        SendRosebank.putExtra("callingActivity", "Rosebank");
        startActivity(SendRosebank);
    }

    public void atEastgate() {
        Intent SendEastgate = new Intent(this, Activity_4.class);
        startActivity(SendEastgate);
        final int result =1;
        SendEastgate.putExtra("callingActivity", "Eastgate");
        startActivity(SendEastgate);

    }

    public void atSandton() {
        Intent SendSandton = new Intent(this, Activity_4.class);
        startActivity(SendSandton);
        final int result =1;
        SendSandton.putExtra("callingActivity", "Sandton");
        startActivity(SendSandton);
    }

    public void atNorthgate() {
        Intent SendNorthgate = new Intent(this, Activity_4.class);
        startActivity(SendNorthgate);
        final int result =1;
        SendNorthgate.putExtra("callingActivity", "Northgate");
        startActivity(SendNorthgate);
    }
}