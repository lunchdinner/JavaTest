package com.example.javatest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);


        //トーストを試しに作っただけ
        Button toastButton = findViewById(R.id.toast_button);
        ForToastListener listener =new ForToastListener();
        toastButton.setOnClickListener(listener);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDataset = new ArrayList<>();
        mDataset.add("A");
        mDataset.add("B");
        mDataset.add("C");

        mAdapter = new MyAdapter(this,mDataset);
        mRecyclerView.setAdapter(mAdapter);


        //MyAdapterクラスに書いたsetOnItemClickListenerメソッドが使えない
//        mAdapter.setOn
    }

    //トースト用のリスナー
    private class ForToastListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(RecyclerViewActivity.this, "ok", Toast.LENGTH_LONG).show();
        }
    }


}
