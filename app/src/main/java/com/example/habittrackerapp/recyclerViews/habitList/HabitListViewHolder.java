package com.example.habittrackerapp.recyclerViews.habitList;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.habittrackerapp.R;

public class HabitListViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView id;
    public HabitListViewHolder(@NonNull View itemView) {
        super(itemView);

        name =itemView.findViewById(R.id.habit_task_name);
        id =itemView.findViewById(R.id.habit_task_id);
    }
}
