package com.example.sqlite_lipsticks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<com.example.sqlite_lipsticks.CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList lipstick_id, lipstick_name, lipstick_company, lipstick_price;

    CustomAdapter(Activity activity, Context context, ArrayList lipstick_id, ArrayList lipstick_name, ArrayList lipstick_company,
                  ArrayList lipstick_price){
        this.activity = activity;
        this.context = context;
        this.lipstick_id = lipstick_id;
        this.lipstick_name = lipstick_name;
        this.lipstick_company = lipstick_company;
        this.lipstick_price = lipstick_price;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.lipstick_id_txt.setText(String.valueOf(lipstick_id.get(position)));
        holder.lipstick_name_txt.setText(String.valueOf(lipstick_name.get(position)));
        holder.lipstick_company_txt.setText(String.valueOf(lipstick_company.get(position)));
        holder.lipstick_price_txt.setText(String.valueOf(lipstick_price.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(lipstick_id.get(position)));
                intent.putExtra("name", String.valueOf(lipstick_name.get(position)));
                intent.putExtra("company", String.valueOf(lipstick_company.get(position)));
                intent.putExtra("price", String.valueOf(lipstick_price.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return lipstick_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView lipstick_id_txt, lipstick_name_txt, lipstick_company_txt, lipstick_price_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            lipstick_id_txt = itemView.findViewById(R.id.lipstick_id_txt);
            lipstick_name_txt = itemView.findViewById(R.id.lipstick_name_txt);
            lipstick_company_txt = itemView.findViewById(R.id.lipstick_company_txt);
            lipstick_price_txt = itemView.findViewById(R.id.lipstick_price_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
