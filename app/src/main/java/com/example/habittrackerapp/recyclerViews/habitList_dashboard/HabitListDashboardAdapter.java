package com.example.habittrackerapp.recyclerViews.habitList_dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.habittrackerapp.R;
import com.example.habittrackerapp.database.DAOs.HabitRecordDao;
import com.example.habittrackerapp.models.Habit;
import com.example.habittrackerapp.models.HabitRecord;

import java.util.Date;
import java.util.List;

public class HabitListDashboardAdapter extends RecyclerView.Adapter<HabitListDashboardViewHolder> {

    HabitRecordDao habitRecordDao;
    List<Habit> list;
    Context context;
    Date chosenDate;


    public HabitListDashboardAdapter(List<Habit> list, Context context, Date chosenDate) {
        this.list = list;
        this.context = context;
        habitRecordDao = new HabitRecordDao(context);
        this.chosenDate = chosenDate;
    }

    @NonNull
    @Override
    public HabitListDashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(context).inflate(R.layout.rv_item_habits, parent, false);
        final HabitListDashboardViewHolder mViewHolder = new HabitListDashboardViewHolder(mView);

//        if(activity != null){
//            mView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    Intent intent = new Intent(activity, WalletDetailActivity.class);
////                    WalletDAO walletDAO = new WalletDAO(activity);
////                    Wallet wallet = walletDAO.GetByName(mViewHolder.walletName.getText().toString());
////                    intent.putExtra("walletId", wallet.getId());
////
////                    activity.startActivity(intent);
//                }
//            });
//        }

        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HabitListDashboardViewHolder holder, int position) {
        holder.id.setText(list.get(position).getId()+"");
        holder.habitName.setText(list.get(position).getName());

        List<HabitRecord> habitRecord = habitRecordDao.GetByHabitId(list.get(position).getId());



        holder.habitStatus.setText(list.get(position).getStatus() + "");


        holder.habitGoal.setText("xxx/"  + list.get(position).getGoal());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
