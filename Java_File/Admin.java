package com.example.user.project;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Admin extends AppCompatActivity {

    EditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
    }

    public void onVerify(View view) {
        String username = user.getText().toString();
        String password = pass.getText().toString();
        if(username.equals("user") && password.equals("admin")) {
            startActivity(new Intent(this, AdminOperation.class));
        }
        else {
            AlertDialog alertDialog;
            Context context=this;
            alertDialog = new AlertDialog.Builder(context).create();
            alertDialog.setMessage("Wrong credential");
            alertDialog.show();
        }
    }
}
