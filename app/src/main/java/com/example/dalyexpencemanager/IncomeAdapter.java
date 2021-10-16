package com.example.dalyexpencemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.ViewHolder> {
    private Context context;
    private ArrayList<IncomeModel> list;


    public IncomeAdapter(Context context, ArrayList<IncomeModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public IncomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.user_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IncomeAdapter.ViewHolder holder, int position) {

        IncomeModel model = list.get(position);

        holder.amountTV.setText(model.getAmount());
        holder.dateTV.setText(model.getDate());
        holder.noteTV.setText(model.getNote());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView amountTV, dateTV, noteTV;

        public ViewHolder(View itemView) {
            super(itemView);

            amountTV = itemView.findViewById(R.id.amount);
            dateTV = itemView.findViewById(R.id.date);
            noteTV = itemView.findViewById(R.id.note);

        }
    }

}
