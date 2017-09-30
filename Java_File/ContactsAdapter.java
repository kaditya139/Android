package com.example.user.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 25-09-2017.
 */
public class ContactsAdapter extends ArrayAdapter{

    List list = new ArrayList();

    public ContactsAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Contacts object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        ContactsHolder contactsHolder;
        if(row == null) {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.raw_layout, parent, false);
            contactsHolder = new ContactsHolder();
            contactsHolder.userID = (TextView)row.findViewById(R.id.userID);
            contactsHolder.password = (TextView)row.findViewById(R.id.password);
            contactsHolder.name = (TextView)row.findViewById(R.id.name);
            contactsHolder.email = (TextView)row.findViewById(R.id.email);
            row.setTag(contactsHolder);
        }
        else {
            contactsHolder = (ContactsHolder)row.getTag();
        }

        Contacts contacts = (Contacts)this.getItem(position);
        contactsHolder.userID.setText(contacts.getUsername());
        contactsHolder.password.setText(contacts.getPassword());
        contactsHolder.name.setText(contacts.getName());
        contactsHolder.email.setText(contacts.getEmail());

        return row;
    }

    static class ContactsHolder {
        TextView userID, password, name, email;
    }
}
