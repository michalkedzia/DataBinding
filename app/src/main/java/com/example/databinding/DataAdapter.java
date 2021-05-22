package com.example.databinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.example.databinding.databinding.ListRowBinding;

import java.util.ArrayList;

public class DataAdapter extends ArrayAdapter<Data> {

    private ArrayList<Data> dataList;
    private Context context;

    public DataAdapter(@NonNull Context context, ArrayList<Data> dataList) {
        super(context, R.layout.list_row, dataList);
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListRowBinding listRowBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_row, parent, false);
        listRowBinding.setDataList(dataList.get(position));
        listRowBinding.setContext(context);
        return listRowBinding.getRoot();
    }
}
