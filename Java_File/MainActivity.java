package com.example.user.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
    }

    public void onLogin(View view) {
        String username = user.getText().toString();
        String password = pass.getText().toString();
        String type ="login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);
    }

    public void onAdmin(View view) {
        startActivity(new Intent(this, Admin.class));
    }
}
