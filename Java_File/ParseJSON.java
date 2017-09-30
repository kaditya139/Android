package com.example.user.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON extends AppCompatActivity {

    String jsonString;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ContactsAdapter contactsAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_json);
        listView = (ListView)findViewById(R.id.listview);
        contactsAdapter = new ContactsAdapter(this, R.layout.raw_layout);
        listView.setAdapter(contactsAdapter);
        jsonString = getIntent().getExtras().getString("jsonData");

        try {
            jsonObject = new JSONObject(jsonString);
            jsonArray = jsonObject.getJSONArray("response");
            String userID, password, name, email;
            int count = 0;
            while (count < jsonArray.length()) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(count);
                userID = jsonObject1.getString("UserID");
                password = jsonObject1.getString("Password");
                name = jsonObject1.getString("Name");
                email = jsonObject1.getString("Email");
                Contacts contacts = new Contacts(userID, password, name, email);
                contactsAdapter.add(contacts);
                count++;
            }
         } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
