package com.example.habittrackerapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.habittrackerapp.R;
import com.example.habittrackerapp.database.DAOs.DailyHabitDao;
import com.example.habittrackerapp.database.DAOs.HabitDao;
import com.example.habittrackerapp.database.DAOs.HabitRecordDao;
import com.example.habittrackerapp.database.DAOs.MonthlyHabitDao;
import com.example.habittrackerapp.database.DAOs.WeeklyHabitDao;
import com.example.habittrackerapp.interfaces.OnDateClickListener;
import com.example.habittrackerapp.models.Habit;
import com.example.habittrackerapp.recyclerViews.datePicker.DatePickerAdapter;
import com.example.habittrackerapp.recyclerViews.habitList.HabitListAdapter;
import com.example.habittrackerapp.recyclerViews.habitList_dashboard.HabitListDashboardAdapter;
import com.example.habittrackerapp.ultilities.DateUltilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment implements OnDateClickListener {

    TextView dashboardHeaderTitle;
    Date chosenDate;
    RecyclerView AnytimeRV;
    RecyclerView MorningRV;
    RecyclerView AfternoonRV;
    RecyclerView EveningRV;
    RecyclerView datePicker;
    List<Habit> AnyTime ;
    List<Habit> Morning ;
    List<Habit> Afternoon ;
    List<Habit> Evening ;
    DailyHabitDao dailyHabitDao;
    MonthlyHabitDao monthlyHabitDao;
    WeeklyHabitDao weeklyHabitDao;
    HabitDao habitDao;
    HabitRecordDao habitRecordDao;

    public DashboardFragment() {
        // Required empty public constructor
    }
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(chosenDate == null){
            chosenDate = new Date();
        }

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        AnytimeRV = view.findViewById(R.id.do_anytime_habits);
        MorningRV = view.findViewById(R.id.morning_habits);
        AfternoonRV = view.findViewById(R.id.afternoon_habits);
        EveningRV = view.findViewById(R.id.evening_habits);
        dashboardHeaderTitle = view.findViewById(R.id.dashboard_header_title);

        dailyHabitDao = new DailyHabitDao(getContext());
        weeklyHabitDao = new WeeklyHabitDao(getContext());
        monthlyHabitDao = new MonthlyHabitDao(getContext());
        habitDao = new HabitDao(getContext());
        habitRecordDao = new HabitRecordDao(getContext());
        //date recycler view
        datePicker = view.findViewById(R.id.date_picker);

        List<Date> dateList = DateUltilities.GetDateListOf2RecentWeek();

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);

        datePicker.setLayoutManager(linearLayoutManager);
        datePicker.setAdapter(new DatePickerAdapter(dateList, this::onItemClick));
        datePicker.smoothScrollToPosition(dateList.size() - 1);

        reloadRV();
        loadRV();
        //
        view.findViewById(R.id.btn_today).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.smoothScrollToPosition(20 - 1);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void getAnyTimeHabitsRV(List<Habit> habits) {
        AnytimeRV.setLayoutManager(new LinearLayoutManager(getContext()));
        AnytimeRV.setAdapter(new HabitListDashboardAdapter(habits, getContext(),chosenDate,0));
    }

    private void getMorningHabitsRV(List<Habit> habits) {
        MorningRV.setLayoutManager(new LinearLayoutManager(getContext()));
        MorningRV.setAdapter(new HabitListDashboardAdapter(habits, getContext(),chosenDate,1));
    }

    private void getAfternoonHabitsRV(List<Habit> habits) {
        AfternoonRV.setLayoutManager(new LinearLayoutManager(getContext()));
        AfternoonRV.setAdapter(new HabitListDashboardAdapter(habits, getContext(),chosenDate,2));
    }

    private void getEveningHabitsRV(List<Habit> habits) {
        EveningRV.setLayoutManager(new LinearLayoutManager(getContext()));
        EveningRV.setAdapter(new HabitListDashboardAdapter(habits, getContext(),chosenDate,3));
    }

    @Override
    public void onItemClick(Date item) {
        chosenDate = item;
        reloadRV();
        if(DateUltilities.isSameDay(chosenDate, new Date())){
            dashboardHeaderTitle.setText("Today");
        }else {
            dashboardHeaderTitle.setText(DateUltilities.FormatDate("dd/MM/yyyy", chosenDate));
        }
    }

    private void reloadRV() {

        List<Habit> daily = dailyHabitDao.DailyHabitToHabitList(dailyHabitDao.GetByDate(chosenDate));
        List<Habit> weekly = weeklyHabitDao.WeeklyHabitToHabitList(weeklyHabitDao.GetAll());
        List<Habit> monthly = monthlyHabitDao.MonthlyHabitToHabitList(monthlyHabitDao.GetByDate(chosenDate));
        List<Habit> anyTime = habitDao.GetOneTimeTaskByDate(chosenDate);

        daily.addAll(weekly);
        daily.addAll(monthly);
        daily.addAll(anyTime);

        if(!DateUltilities.isSameDay(chosenDate, new Date())){
            Iterator<Habit> iterator = daily.iterator();
            while (iterator.hasNext()){
                if(!habitRecordDao.IsHabitHaveRecord(iterator.next().getId(), chosenDate)){
                    iterator.remove();
                }
            }
        }

        AnyTime = new ArrayList<>();
        Morning = new ArrayList<>();
        Afternoon = new ArrayList<>();
        Evening = new ArrayList<>();

        for (Habit h: daily) {
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
        loadRV();
    }

    private void loadRV(){
        getAnyTimeHabitsRV(AnyTime);
        getMorningHabitsRV(Morning);
        getAfternoonHabitsRV(Afternoon);
        getEveningHabitsRV(Evening);
    }
}