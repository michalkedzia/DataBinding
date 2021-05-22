package com.example.databinding;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;

public class Data {
    private String header;
    private String description;

    public Data(String header, String description) {
        this.header = header;
        this.description = description;
    }

    public Data(CharSequence header, CharSequence description) {
        this.header = header.toString();
        this.description = description.toString();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void make(Context context) {
        Toast.makeText(context, this.header, Toast.LENGTH_SHORT).show();
    }

    @BindingAdapter("android:toUpperCase")
    public static void headerToUpperCase(TextView view, String header) {
        view.setText(header.toUpperCase());
    }
}
