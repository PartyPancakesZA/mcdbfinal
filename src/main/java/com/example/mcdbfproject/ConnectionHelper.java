package com.example.mcdbfproject;

import android.content.Context;

import android.os.AsyncTask;



import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;





public class ConnectionHelper extends AsyncTask<String,Void,String> {
    Context connect;

    ConnectionHelper(Context connect) {
        this.connect = connect;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "https://lamp.ms.wits.ac.za/~s2395258/register.php";
        String login_url = "";
        String method = params[0];
        if (method.equals("register")) {
            String User_FName = params[1];
            String User_LName = params[2];
            String User_date = params[3];
            String User_Username = params[4];
            String User_password = params[5];


            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("FName", "UTF-8") + "=" + URLEncoder.encode(User_FName, "UTF-8") + "&" +
                        URLEncoder.encode("LName", "UTF-8") + "=" + URLEncoder.encode(User_LName, "UTF-8") + "&" +
                        URLEncoder.encode("Address", "UTF-8") + "=" + URLEncoder.encode(User_date, "UTF-8") + "&" +
                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(User_Username, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(User_password, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
                String line;
                String result = "";
                while ((line = reader.readLine()) != null) {
                    result = result + line;
                }
                IS.close();
                reader.close();
                httpURLConnection.disconnect();
                return "Registration success...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException c) {
                c.printStackTrace();
            }

        }else if (method.equals("Login")) {
            String User_FName = params[1];
            String User_Username = params[4];
            String User_password = params[5];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("FName", "UTF-8") + "=" + URLEncoder.encode(User_FName, "UTF-8") + "&" +
                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(User_Username, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(User_password, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(IS, "iso-8859-1"));
                String line;
                String result = "";
                while ((line = reader.readLine()) != null) {
                    result = result + line;
                }
                IS.close();
                reader.close();
                httpURLConnection.disconnect();
                return "Login success...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException c) {
                c.printStackTrace();
            }

        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Toast.makeText(connect, result, Toast.LENGTH_LONG).show();

    }

}


