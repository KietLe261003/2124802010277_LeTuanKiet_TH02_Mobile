package com.example.a2124802010277_letuankiet_bth02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocalationAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> Localations;
    public LocalationAdapter(Context context, ArrayList<String> Loaclations) {
        super(context, R.layout.customlistviewlayout, Loaclations);
        this.context = context;
        this.Localations = Loaclations;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.customlistviewlayout, parent, false);
        }

        ImageView icon = convertView.findViewById(R.id.imgIcon);
        TextView txtName = convertView.findViewById(R.id.txtName);

        String local=Localations.get(position);
        txtName.setText(local+"");
        if(local.length()<=3)
            icon.setImageResource(R.drawable.star);
        else
            icon.setImageResource(R.drawable.global);

        return convertView;
    }


}
