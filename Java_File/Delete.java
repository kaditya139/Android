package com.example.user.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class Delete extends AppCompatActivity {

    Spinner spinner;
    EditText value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        spinner = (Spinner)findViewById(R.id.attribute);
        value = (EditText)findViewById(R.id.value);
    }

    public void deleteInfo(View view) {
        String attribute = spinner.getSelectedItem().toString();
        String val = value.getText().toString();
        String type = "delete";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, attribute, val);
    }
}
