package com.example.habittrackerapp.recyclerViews.habitList_dashboard;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.habittrackerapp.R;

public class HabitListDashboardViewHolder extends RecyclerView.ViewHolder {
    TextView id;
    TextView habitName;
    TextView habitStatus;
    TextView habitGoal;
    public HabitListDashboardViewHolder(@NonNull View itemView) {
        super(itemView);

        habitName =itemView.findViewById(R.id.habit_name);
        habitStatus =itemView.findViewById(R.id.habit_status);
        habitGoal =itemView.findViewById(R.id.habit_goal);
        id =itemView.findViewById(R.id.habitid);
    }
}
