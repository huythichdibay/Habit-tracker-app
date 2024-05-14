package com.example.habittrackerapp.recyclerViews.habitList_dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.habittrackerapp.R;
import com.example.habittrackerapp.database.DAOs.HabitDao;
import com.example.habittrackerapp.database.DAOs.HabitRecordDao;
import com.example.habittrackerapp.models.Habit;
import com.example.habittrackerapp.models.HabitRecord;
import com.example.habittrackerapp.ultilities.DateUltilities;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HabitListDashboardAdapter extends RecyclerView.Adapter<HabitListDashboardViewHolder> {

    HabitRecordDao habitRecordDao;
    List<Habit> list;
    int timeInDay; //1 ,2,3 0
    Context context;
    Date chosenDate;


    public HabitListDashboardAdapter(List<Habit> list, Context context, Date chosenDate, int timeInDay) {
        this.list = list;
        this.context = context;
        habitRecordDao = new HabitRecordDao(context);
        this.chosenDate = chosenDate;
        this.timeInDay = timeInDay;
    }

    @NonNull
    @Override
    public HabitListDashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(context).inflate(R.layout.rv_item_habits, parent, false);
        final HabitListDashboardViewHolder mViewHolder = new HabitListDashboardViewHolder(mView);

            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    
                }
            });


        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HabitListDashboardViewHolder holder, int position) {
        holder.id.setText(list.get(position).getId()+"");
        holder.habitName.setText(list.get(position).getName());
        Habit haa = new HabitDao(context).GetById(list.get(position).getId());
        List<HabitRecord> habitRecord = habitRecordDao.GetRecordByHabitIdAndDate(list.get(position).getId(), chosenDate);
        if(habitRecord.size()!= 1){
            Iterator<HabitRecord> iterator = habitRecord.iterator();
            while (iterator.hasNext()){
                if(iterator.next().getTimeInDay() != timeInDay && haa.getType()!=0){
                    iterator.remove();
                }
            }
        }

        if(habitRecord.size()==0){
            holder.habitStatus.setText("In progress");
        }else{
            if(DateUltilities.isSameDay(chosenDate, new Date())){
                holder.habitStatus.setText("In progress");
                holder.habitGoal.setText(habitRecord.get(0).getGoal() +"/"  + list.get(position).getGoal());
            }else{
                holder.habitStatus.setText(habitRecord.get(0).getStatus());
                holder.habitGoal.setText(habitRecord.get(0).getGoal() +"/"  + list.get(position).getGoal());
            }
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
