package com.example.habittrackerapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.habittrackerapp.R;
import com.example.habittrackerapp.database.DAOs.HabitDao;
import com.example.habittrackerapp.models.Habit;
import com.example.habittrackerapp.recyclerViews.habitList.HabitListAdapter;

import java.util.ArrayList;
import java.util.List;

public class AllHabitActivity extends AppCompatActivity {

    RecyclerView allMorningHabitRV;
    RecyclerView allAfternoonHabitRV;
    RecyclerView allEveningHabitRV;
    RecyclerView allAnyTimeHabitRV;
    HabitDao habitDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_habit);

        //hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        habitDao = new HabitDao(getApplicationContext());

        allMorningHabitRV = findViewById(R.id.all_morning_habit_rv);
        allAfternoonHabitRV = findViewById(R.id.all_afternoon_habit_rv);
        allEveningHabitRV = findViewById(R.id.all_evening_habit_rv);
        allAnyTimeHabitRV = findViewById(R.id.all_anytime_habit_rv);

        getRV();

        findViewById(R.id.habit_exit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllHabitActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getRV() {
        List<Habit> habits = habitDao.GetAll();

        List<Habit> AnyTime = new ArrayList<>();
        List<Habit> Morning = new ArrayList<>();
        List<Habit> Afternoon = new ArrayList<>();
        List<Habit> Evening = new ArrayList<>();

        for (Habit h: habits) {
            if(h.getRepeatedDaily() == 0){
                AnyTime.add(h);
            }  if (String.valueOf(h.getRepeatedDaily()).contains("1")) {
                Morning.add(h);
            }
            if (String.valueOf(h.getRepeatedDaily()).contains("2")) {
                Afternoon.add(h);
            }
            if (String.valueOf(h.getRepeatedDaily()).contains("3")) {
                Evening.add(h);
            }

        }

        allMorningHabitRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        allMorningHabitRV.setAdapter(new HabitListAdapter(Morning, getApplicationContext(), this));

        allAfternoonHabitRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        allAfternoonHabitRV.setAdapter(new HabitListAdapter(Afternoon, getApplicationContext(), this));

        allEveningHabitRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        allEveningHabitRV.setAdapter(new HabitListAdapter(Evening, getApplicationContext(), this));

        allAnyTimeHabitRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        allAnyTimeHabitRV.setAdapter(new HabitListAdapter(AnyTime, getApplicationContext(), this));
    }
}