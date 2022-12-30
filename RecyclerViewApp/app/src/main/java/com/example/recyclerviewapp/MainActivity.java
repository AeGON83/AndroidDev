package com.example.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText[] name = new EditText[1];
        final EditText[] number = new EditText[1];

        contacts = findViewById(R.id.contacts);
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog addContact = new Dialog(MainActivity.this);
                addContact.setContentView(R.layout.add_contact);
                addContact.show();

                number[0] =addContact.findViewById(R.id.contactNum);
                name[0] =addContact.findViewById(R.id.contactName);
            }

        });




        ArrayList<ContactDetails> contactList = new ArrayList<>();

        for(int i=0;i<10;i++)
        {
            contactList.add(new ContactDetails("Rajan", "6353990537"));
            contactList.add(new ContactDetails("Sanpai", "6353993533"));
            contactList.add(new ContactDetails("Daemon", "6353993533"));
            contactList.add(new ContactDetails("John Wick", "6353993533"));
            contactList.add(new ContactDetails("Jay Makwana", "6353993533"));
            contactList.add(new ContactDetails("Parth Gajjar", "6353993533"));
            contactList.add(new ContactDetails("Sam Curran", "6353993533"));
            contactList.add(new ContactDetails("Gal Gadot", "6353993533"));
            contactList.add(new ContactDetails("James Bond", "6353993533"));
            contactList.add(new ContactDetails("Aegon Targeryan", "6353993533"));
            contactList.add(new ContactDetails("Sanpai", "6353993533"));
            contactList.add(new ContactDetails("Daemon", "6353993533"));
            contactList.add(new ContactDetails("John Wick", "6353993533"));
            contactList.add(new ContactDetails("Jay Makwana", "6353993533"));
            contactList.add(new ContactDetails("Parth Gajjar", "6353993533"));
            contactList.add(new ContactDetails("Sam Curran", "6353993533"));
            contactList.add(new ContactDetails("Gal Gadot", "6353993533"));
            contactList.add(new ContactDetails("James Bond", "6353993533"));
            contactList.add(new ContactDetails("Aegon Targeryan", "6353993533"));
        }

        RecyclerView rv = findViewById(R.id.contactsList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ContactsViewAdatpter adapter = new ContactsViewAdatpter(this , contactList);
        rv.setAdapter(adapter);



    }
}