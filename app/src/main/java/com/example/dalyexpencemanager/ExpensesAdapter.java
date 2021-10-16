package com.example.dalyexpencemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.ViewHolder> {

    public Context context;
    public ArrayList<ExpensesModel>list;

    public ExpensesAdapter(Context context, ArrayList<ExpensesModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ExpensesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(context).inflate(R.layout.expenses_rv_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpensesAdapter.ViewHolder holder, int position) {

        ExpensesModel model= list.get(position);

        holder.amountTV.setText(model.getAmount());
        holder.dateTV.setText(model.getDate());
        holder.noteTV.setText(model.getNote());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView amountTV,dateTV,noteTV;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            amountTV=itemView.findViewById(R.id.Amount);
            dateTV=itemView.findViewById(R.id.Date);
            noteTV=itemView.findViewById(R.id.Note);
        }
    }
}
