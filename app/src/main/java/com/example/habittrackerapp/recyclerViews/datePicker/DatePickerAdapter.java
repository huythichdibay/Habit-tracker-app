package com.example.habittrackerapp.recyclerViews.datePicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.habittrackerapp.R;

import java.util.Date;
import java.util.List;

public class DatePickerAdapter extends RecyclerView.Adapter<DatePickerViewHolder> {

    List<Date> dates;

    public DatePickerAdapter(List<Date> dates) {
        this.dates = dates;
    }

    @NonNull
    @Override
    public DatePickerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DatePickerViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_date, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull DatePickerViewHolder holder, int position) {
        holder.date.setText(dates.get(position).getDate() + "");
        if(dates.get(position).getDay() == 0){
            holder.dayOfWeek.setText("CN");
        }else{
            holder.dayOfWeek.setText("Th " + (dates.get(position).getDay() + 1));
        }
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }
}
