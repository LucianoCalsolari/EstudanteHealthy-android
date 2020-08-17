package br.com.estudantehealthy.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.com.estudantehealthy.R;

public class Adapter_timeof_tasks extends RecyclerView.Adapter<Adapter_timeof_tasks.MyViewHolder> {

    public Context mContext;

    public Adapter_timeof_tasks(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rankList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_timeof_tasks, parent, false);

        MyViewHolder vHolder = new MyViewHolder(rankList);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
