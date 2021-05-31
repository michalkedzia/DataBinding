package com.example.databinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.databinding.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private ArrayList<Data> dataList = new ArrayList<>();
    private DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataList.add(new Data("Header1", "Description1"));
        dataList.add(new Data("Header2", "Description2"));
        dataList.add(new Data("Header3", "Description3"));

        dataAdapter = new DataAdapter(this, dataList);
        activityMainBinding.listview.setAdapter(dataAdapter);

        activityMainBinding.setOnButtonClicked(v -> {
            dataList.add(new Data(activityMainBinding.getTextHeader(), activityMainBinding.getTextDescription()));
            dataAdapter.notifyDataSetChanged();
        });
    }
}