package com.examprel.examprep.BarCode;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.examprel.examprep.R;

import java.util.List;

public class BarAdapter extends RecyclerView.Adapter<BarAdapter.MyViewHolder> {
    private List<BarList> barList;

    @Override
    public BarAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BarAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCode;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvCode = (TextView)itemView.findViewById(R.id.tv_code_bar);
        }
    }
}
