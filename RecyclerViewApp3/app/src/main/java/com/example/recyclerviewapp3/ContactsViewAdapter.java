package com.example.recyclerviewapp3;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ContactsViewAdapter extends RecyclerView.Adapter<ContactsViewAdapter.ViewHolder> {

    Context context;
    ArrayList<ContactDetails> arrayList;
    public ContactsViewAdapter(Context context , ArrayList<ContactDetails> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.contacts_view ,parent , false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).name);
        holder.number.setText(arrayList.get(position).number);
        holder.profile.setText(arrayList.get(position).profile);
        Dialog dialog;

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context , android.R.style.Theme_Light);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.add_contact);
                dialog.show();

                EditText number =dialog.findViewById(R.id.contactNum);
                EditText name =dialog.findViewById(R.id.contactName);
                Button addButton2 = dialog.findViewById(R.id.add_button2);
                TextView error = dialog.findViewById(R.id.errorTextView);
                TextView title = dialog.findViewById(R.id.title);


                title.setText("Edit Existing Contact");
                addButton2.setText("UPDATE");
                name.setText(arrayList.get(position).name);
                number.setText(arrayList.get(position).number);


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
                            arrayList.set(position , new ContactDetails(nameStr , numStr));

                            notifyItemChanged(position);

                            dialog.dismiss();

                        }
                    }
                });

            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name , number , profile;
        LinearLayout container,close;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            profile = itemView.findViewById(R.id.profile);
            container = itemView.findViewById(R.id.containerLayout);


//            Random rnd = new Random();
//            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//            profile.setBackgroundColor(color);
        }
    }
}
