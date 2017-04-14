package com.example.utsav.test.activity.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.utsav.test.R;
import com.example.utsav.test.activity.model.Batch;

import java.util.ArrayList;

/**
 * Created by utsav on 14-04-2017.
 */

public class BatchAdapter extends RecyclerView.Adapter<BatchAdapter.BatchViewHolder> {
    private ArrayList<Batch> batchArrayList = new ArrayList<>();
    private Context context;

    @Override
    public BatchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_batch, parent, false);
        return new BatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BatchViewHolder holder, int position) {
        Batch batch = batchArrayList.get(position);
        holder.tvBatch.setText("");

    }

    @Override
    public int getItemCount() {
        return batchArrayList.size();
    }

    static class BatchViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView tvBatch;

        public BatchViewHolder(View itemView) {
            super(itemView);
            tvBatch = (AppCompatTextView) itemView.findViewById(R.id.tv_batch);
        }
    }
}
