package com.example.habittrackerapp.recyclerViews.datePicker;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.habittrackerapp.R;

public class DatePickerViewHolder extends RecyclerView.ViewHolder {
    TextView dayOfWeek;
    TextView date;

    public DatePickerViewHolder(@NonNull View itemView) {
        super(itemView);

        dayOfWeek = itemView.findViewById(R.id.day_of_week);
        date = itemView.findViewById(R.id.date);
    }
}
