package com.example.habittrackerapp.recyclerViews.habitList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.habittrackerapp.R;
import com.example.habittrackerapp.models.Habit;

import java.util.List;

public class HabitListAdapter extends RecyclerView.Adapter<HabitListViewHolder> {

    List<Habit> list;
    Context context;
    Activity activity;

    public HabitListAdapter(List<Habit> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public HabitListAdapter(List<Habit> list, Context context, Activity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public HabitListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(context).inflate(R.layout.item_rv_habit_task, parent, false);
        final HabitListViewHolder mViewHolder = new HabitListViewHolder(mView);

        if(activity != null){
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Intent intent = new Intent(activity, WalletDetailActivity.class);
//                    WalletDAO walletDAO = new WalletDAO(activity);
//                    Wallet wallet = walletDAO.GetByName(mViewHolder.walletName.getText().toString());
//                    intent.putExtra("walletId", wallet.getId());
//
//                    activity.startActivity(intent);
                }
            });
        }

        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HabitListViewHolder holder, int position) {
        holder.id.setText(list.get(position).getId()+"");
        holder.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
