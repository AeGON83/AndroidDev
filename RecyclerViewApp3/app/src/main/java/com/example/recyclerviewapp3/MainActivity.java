package com.example.recyclerviewapp3;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.app.Dialog;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.view.View;
        import android.view.Window;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import com.google.android.material.floatingactionbutton.FloatingActionButton;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ContactDetails> contactList;
    ContactsViewAdapter adapter;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        FloatingActionButton addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog addContact = new Dialog(MainActivity.this , android.R.style.Theme_Light);
                addContact.requestWindowFeature(Window.FEATURE_NO_TITLE);
                addContact.setContentView(R.layout.add_contact);
                addContact.show();

                EditText number =addContact.findViewById(R.id.contactNum);
                EditText name =addContact.findViewById(R.id.contactName);
                Button addButton2 = addContact.findViewById(R.id.add_button2);
                TextView error = addContact.findViewById(R.id.errorTextView);


                addButton2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nameStr = name.getText().toString();
                        String numStr = number.getText().toString();
                        if(nameStr.isEmpty()){
                            name.setHintTextColor(Color.parseColor("#FFD50000"));
                            error.setText("Name can't be empty");
                            return;
                        }
                        else if(numStr.isEmpty()){
                            number.setHintTextColor(Color.parseColor("#FFD50000"));
                            error.setText("Number can't be empty");
                            return;
                        }
                        else if(numStr.length()>12){
                            error.setText("Number can be only 12 digits long");
                            return;
                        }
                        else{
                            error.setText("");

                            contactList.add(new ContactDetails(nameStr , numStr));

                            adapter.notifyItemInserted(contactList.size()-1);

                            rv.scrollToPosition(contactList.size()-1);

                            addContact.dismiss();

                        }
                    }
                });
            }

        });






        contactList = new ArrayList<ContactDetails>();

        for(int i=0;i<10;i++)
        {
            contactList.add(new ContactDetails("Rajan", "6353990537"));
            contactList.add(new ContactDetails("Parth", "9056353937"));
            contactList.add(new ContactDetails("Gus Fring", "234321234"));
            contactList.add(new ContactDetails("Patrick Bateman", "234321234"));
            contactList.add(new ContactDetails("Tyler Durden", "5635321234"));
            contactList.add(new ContactDetails("Walter White", "212342343"));
            contactList.add(new ContactDetails("John Wick", "223431234"));
            contactList.add(new ContactDetails("Steve Rodgers", "123441234"));
            contactList.add(new ContactDetails("Paul Walker", "5324321234"));
            contactList.add(new ContactDetails("Eric Cantona", "777221234"));
        }

        rv = findViewById(R.id.contactsList);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ContactsViewAdapter(this , contactList);
        rv.setAdapter(adapter);



    }
}