package com.example.locationreminder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context;
    Activity activity;
    ArrayList id, title, note; //
    int position;


    CustomAdapter(Activity activity, Context context, ArrayList id, ArrayList title, ArrayList note)
    {
        this.activity = activity;
        this.context = context;
        this.id = id;
        this.title = title; //
        this.note = note;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.data_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        this.position = position;
        holder.id_txt.setText(String.valueOf(id.get(position)));
        holder.title_txt.setText(String.valueOf(title.get(position))); //
        holder.note_txt.setText(String.valueOf(note.get(position)));
        holder.updateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Update.class);
                intent.putExtra("id", String.valueOf(id.get(position)));
                intent.putExtra("title", String.valueOf(title.get(position))); //
                intent.putExtra("note", String.valueOf(note.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public int getItemCount() {

        return id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView id_txt, title_txt, note_txt;
        LinearLayout updateLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id_txt = itemView.findViewById(R.id.note_id);
            title_txt = itemView.findViewById(R.id.note_title); //
            note_txt = itemView.findViewById(R.id.note_data);
            updateLayout = itemView.findViewById(R.id.updateLayout);
        }
    }
}
