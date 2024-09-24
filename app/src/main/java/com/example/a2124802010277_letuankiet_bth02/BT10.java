package com.example.a2124802010277_letuankiet_bth02;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class BT10 extends AppCompatActivity {
    ListView listView;
    TextView txtSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bt10);
        listView = findViewById(R.id.listView);
        txtSelected = findViewById(R.id.txtSelected);
        String[] arryLocal= getResources().getStringArray(R.array.local_array);
        ArrayList<String> localations=new ArrayList<>(Arrays.asList(arryLocal));
        LocalationAdapter adapter = new LocalationAdapter(this,localations);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name=localations.get(i);
                txtSelected.setText("Position: "+(i+1)+" Value: "+name);
            }
        });
    }
}