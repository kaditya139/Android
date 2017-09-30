package com.example.user.project;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchJSON extends AppCompatActivity {

    String jsonString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_json);
    }

    public void getJson(View view) {
        new BackgroundTask().execute();
    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {

        String jsonUrl;

        @Override
        protected void onPreExecute() {
            jsonUrl = "http://10.31.47.99/project/fetch.php";
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                URL url = new URL(jsonUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder = new StringBuilder();
                while ((jsonString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(jsonString+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(result);
            jsonString = result;
        }
    }

    public void parseJson(View view) {
        if(jsonString == null) {
            Toast.makeText(getApplicationContext(), "First Get JSON", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, ParseJSON.class);
            intent.putExtra("jsonData", jsonString);
            startActivity(intent);
        }
    }
}
