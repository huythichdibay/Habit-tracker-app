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

import java.util.List;

public class AllTasksActivity extends AppCompatActivity {

    HabitDao habitDao;
    RecyclerView tasksRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks);

        //hide action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        tasksRV = findViewById(R.id.all_task_rv);

        habitDao = new HabitDao(getApplicationContext());

        getAnyTimeHabitsRV();

        findViewById(R.id.task_exit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllTasksActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void getAnyTimeHabitsRV() {
        tasksRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        tasksRV.setAdapter(new HabitListAdapter(habitDao.GetAllOneTimeTask(), getApplicationContext(), this));
    }
}