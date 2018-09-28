package com.examprel.examprep;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<Data> dataList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name,standard,stream;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            standard = (TextView)itemView.findViewById(R.id.standard);
            stream = (TextView)itemView.findViewById(R.id.stream);

        }
    }
    public RecyclerAdapter(List<Data>dataList){
        this.dataList = dataList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
Data data = dataList.get(position);
holder.name.setText(data.getName());
holder.standard.setText(data.getStandard());
holder.stream.setText(data.getStream());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
