package com.example.habittrackerapp.recyclerViews.datePicker;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.habittrackerapp.R;
import com.example.habittrackerapp.interfaces.OnDateClickListener;

import java.util.Date;
import java.util.List;

public class DatePickerAdapter extends RecyclerView.Adapter<DatePickerViewHolder> {
    private OnDateClickListener listener;
    List<Date> dates;
    private int row_index = -1;
    public DatePickerAdapter(List<Date> dates, OnDateClickListener listener) {
        this.dates = dates;
        row_index = dates.size() -1;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DatePickerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_date, parent, false);
        final DatePickerViewHolder datePickerViewHolder = new DatePickerViewHolder(mView);

        return datePickerViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull DatePickerViewHolder holder, int position) {
        holder.date.setText(dates.get(position).getDate() + "");
        if(dates.get(position).getDay() == 0){
            holder.dayOfWeek.setText("CN");
        }else{
            holder.dayOfWeek.setText("Th " + (dates.get(position).getDay() + 1));
        }

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = holder.getAdapterPosition();
                notifyDataSetChanged();
                if(listener != null){
                    listener.onItemClick(position);
                }
            }
        });

        if(row_index==position){
            holder.view.setBackgroundColor(Color.parseColor("#567845"));
        }
        else
        {
            holder.view.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }
}
