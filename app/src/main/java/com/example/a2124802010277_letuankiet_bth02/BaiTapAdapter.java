package com.example.a2124802010277_letuankiet_bth02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class BaiTapAdapter extends ArrayAdapter<ContentBt> {
    private final Context context;
    private final ArrayList<ContentBt> ListBaiTap;
    public BaiTapAdapter(@NonNull Context context, ArrayList<ContentBt> listBaiTap) {
        super(context,R.layout.itembaitap, listBaiTap);
        this.context = context;
        ListBaiTap = listBaiTap;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.itembaitap, parent, false);
        }

        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtContent = convertView.findViewById(R.id.txtContent);

        ContentBt bt=ListBaiTap.get(position);
        txtName.setText(bt.getName());
        txtContent.setText(bt.getContent());
        return convertView;
    }

}