package com.example.javatest;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemViewHolder> {

    ArrayList<String> mDataset;


    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public ItemViewHolder (View v) {
            super(v);
            mTextView = v.findViewById(R.id.textView1);
        }
    }

    public MyAdapter (ArrayList<String> mDataset) {
        this.mDataset = mDataset;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        final String data;
        data = mDataset.get(position);
        holder.mTextView.setText(mDataset.get(position));
        holder.mTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //トーストはエラーが出るので一旦放置
                //Toast toast = Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();

                Log.d("recycler", "OK");
            }
        });
    }

    @Override
    public  int getItemCount(){
        return mDataset.size();
    }
}