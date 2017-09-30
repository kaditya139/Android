package com.example.user.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class Update extends AppCompatActivity {

    Spinner spinner1, spinner2;
    EditText old_val, new_val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        spinner1 = (Spinner)findViewById(R.id.attribute1);
        old_val = (EditText)findViewById(R.id.oldval);
        spinner2 = (Spinner)findViewById(R.id.attribute2);
        new_val = (EditText)findViewById(R.id.newval);
    }

    public void updateInfo(View view) {
        String attribute1 = spinner1.getSelectedItem().toString();
        String oldval = old_val.getText().toString();
        String attribute2 = spinner2.getSelectedItem().toString();
        String newval = new_val.getText().toString();
        String type = "update";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, attribute1, oldval, attribute2, newval);
    }
}
