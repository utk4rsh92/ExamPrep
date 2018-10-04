package com.examprel.examprep.BarCode;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.examprel.examprep.R;

import java.util.List;

public class BarAdapter extends RecyclerView.Adapter<BarAdapter.MyViewHolder> {
    private List<BarList> barList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCode;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvCode = (TextView)itemView.findViewById(R.id.tv_code_bar);
        }
    }
    public BarAdapter(List<BarList>dataList){
        this.barList = barList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BarList bar  = barList.get(position);
        holder.tvCode.setText(bar.getCodename());

    }

    @Override
    public int getItemCount() {
        return barList.size();
    }


}
