package com.xela.browser.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xela.browser.MainActivity;
import com.xela.browser.NetworkState;
import com.xela.browser.R;
import com.xela.browser.model.HistoryData;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    private List<HistoryData> dataRecycler;

    public HistoryAdapter(List<HistoryData> dataRecycler) {
        this.dataRecycler = dataRecycler;
    }

    @NonNull
    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_history_recview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.MyViewHolder holder, int position) {
        holder.no.setText(dataRecycler.get(position).getNo());
        holder.link_btn.setText(dataRecycler.get(position).getLink());
        holder.link_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataRecycler.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView no;
        Button link_btn;

        public MyViewHolder(View itemView){
            super(itemView);
            no = itemView.findViewById(R.id.number);
            link_btn = itemView.findViewById(R.id.link);
        }
    }
}
