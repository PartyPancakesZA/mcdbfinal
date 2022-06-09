package com.example.mcdbfproject;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Calendar;

public class Activity_4 extends Activity {

    private static final String TAG = "SecondScreen";

    private TextView mDisplayDate;
    private TextView mDisplayPlace;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextView mFinalDisplay;
    private Button mShowData;
    private CheckBox mYes, mNo;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_4);

        mDisplayPlace = (TextView) findViewById(R.id.textViewPlace);
        mFinalDisplay = (TextView) findViewById(R.id.showdata);
        mShowData = (Button) findViewById(R.id.buttonsearch);
        mYes = (CheckBox) findViewById(R.id.CovidYes);
        mNo = (CheckBox) findViewById(R.id.CovidNO);
        mFinalDisplay.setEnabled(false);

        mDisplayDate = (TextView) findViewById(R.id.textViewDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(Activity_4.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = dayOfMonth+"/"+month+"/"+year;
                mDisplayDate.setText(date);
                // add date to database
            }
        };

        Intent activityCalls = getIntent();
        String place = activityCalls.getExtras().getString("callingActivity");
        mDisplayPlace.setText(place);
        // add place to database

        mShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mYes.isChecked())
                    ;// add to database;
                if (mNo.isChecked())
                    ;// add to database
                mFinalDisplay.setText("databse info here");

            }
        });



    }
}
