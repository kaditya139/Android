package com.example.user.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdminOperation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_operation);
    }

    public void onInsert(View view) {
        startActivity(new Intent(this, Insert.class));
    }

    public void onFetch(View view) {
        startActivity(new Intent(this, FetchJSON.class));
    }

    public void onUpdate(View view) {
        startActivity(new Intent(this, Update.class));
    }

    public void onDelete(View view) {
        startActivity(new Intent(this, Delete.class));
    }
}
