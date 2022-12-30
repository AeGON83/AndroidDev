package com.example.recyclerviewapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class ContactsViewAdatpter extends RecyclerView.Adapter<ContactsViewAdatpter.vh> {
    Context context;
    ArrayList<ContactDetails> arrayList;
    public ContactsViewAdatpter(Context context , ArrayList<ContactDetails> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.sample ,parent , false);
        return new vh(v);
    }

    @Override
    public void onBindViewHolder(@NonNull vh holder, int position) {
        holder.name.setText(arrayList.get(position).name);
        holder.number.setText(arrayList.get(position).number);
        holder.profile.setText(arrayList.get(position).profile);
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class vh extends RecyclerView.ViewHolder {

        TextView name , number , profile;


        public vh(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            profile = itemView.findViewById(R.id.profile);
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            profile.setBackgroundColor(color);
        }
    }


}
