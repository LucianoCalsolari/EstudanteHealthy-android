package br.com.estudantehealthy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.com.estudantehealthy.R;

public class Adapter_tasks extends RecyclerView.Adapter<Adapter_tasks.MyViewHolder> {

    Context mContext;

    public Adapter_tasks(Context mContext){
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View taskList = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.frag3_layout, parent, false);
        MyViewHolder vHolder = new MyViewHolder(taskList);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text_title.setText("Teste de tarefa");
        holder.text_description.setText("Fazer algo com cuidado e avisar");
        holder.date.setText("12:00");
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text_title;
        TextView date;
        TextView text_description;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
             text_title = itemView.findViewById(R.id.text_name_task);
             date = itemView.findViewById(R.id.text_hour_task);
             text_description = itemView.findViewById(R.id.text_description_task);

        }
    }
}
