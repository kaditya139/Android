package com.example.user.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Insert extends AppCompatActivity {

    EditText user, pass, pname, emailid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        pname = (EditText)findViewById(R.id.name);
        emailid = (EditText)findViewById(R.id.email);
    }

    public void insertInfo(View view) {
        String username = user.getText().toString();
        String password = pass.getText().toString();
        String name = pname.getText().toString();
        String email = emailid.getText().toString();
        String type = "insert";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password, name, email);
    }
}
