package com.example.locationreminder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context;
    ArrayList id, note;
    int position;


    CustomAdapter(Context context, ArrayList id, ArrayList note)
    {
        this.context = context;
        this.id = id;
        this.note = note;
    }



    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.data_row, parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, final int position) {
        this.position = position;
        holder.id_txt.setText(String.valueOf(id.get(position)));
        holder.note_txt.setText(String.valueOf(note.get(position)));
    }

    @Override
    public int getItemCount() {

        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView id_txt, note_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id_txt = itemView.findViewById(R.id.note_id);
            note_txt = itemView.findViewById(R.id.note_data);
        }
    }
}
