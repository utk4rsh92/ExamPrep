package com.examprel.examprep.sqlite;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.examprel.examprep.R;

import java.util.List;

public class SqLiteRecycler extends RecyclerView.Adapter<SqLiteRecycler.MyHolder> {
    List<DataModel> dataModelArrayList;

    public SqLiteRecycler(List<DataModel> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public MyHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
     DataModel dataModel = dataModelArrayList.get(position);
     holder.tvname.setText(dataModel.name);
     holder.tvstandard.setText(dataModel.standard);
     holder.tvStream.setText(dataModel.stream);
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvname,tvstandard,tvStream;
        public MyHolder(View itemView) {
            super(itemView);
            tvname = (TextView)itemView.findViewById(R.id.name1);
            tvstandard = (TextView)itemView.findViewById(R.id.city1);
            tvStream = (TextView)itemView.findViewById(R.id.country1);
        }
    }
}
