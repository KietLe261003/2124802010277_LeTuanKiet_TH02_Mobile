package com.example.a2124802010277_letuankiet_bth02;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class BT9 extends AppCompatActivity {
    ListView listView;
    TextView txtSelected;
    EditText edtName;
    Button btnPush;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bt9);
        listView = findViewById(R.id.listView);
        txtSelected = findViewById(R.id.txtSelected);
        edtName=findViewById(R.id.edtName);
        btnPush=findViewById(R.id.btnPush);


        String[] namesArray = getResources().getStringArray(R.array.names_array);
        ArrayList<String> names = new ArrayList<>(Arrays.asList(namesArray));
        //Load dữ liệu lên list view
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name=names.get(i);
                txtSelected.setText("Position: "+(i+1)+" Value: "+name);
            }
        });
        //Thêm dữ liệu nek
        btnPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName= edtName.getText().toString();
                names.add(newName);
                adapter.notifyDataSetChanged();
                edtName.setText("");
            }
        });
    }
}