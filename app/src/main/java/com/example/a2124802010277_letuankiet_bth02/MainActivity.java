package com.example.a2124802010277_letuankiet_bth02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView taskListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        taskListView=findViewById(R.id.taskListView);
        ArrayList<ContentBt> listTask= new ArrayList<>();
        ContentBt bt1= new ContentBt("BT1","Toast", BT1Toast.class);
        ContentBt bt2= new ContentBt("BT2","Dialog", BT2Dialog.class);
        ContentBt bt3 = new ContentBt("BT3","Thực hành và hiểu được các kiểu lập trình sự kiện trong Android", BT3.class);
        ContentBt bt4 = new ContentBt("BT4","Thực hành và hiểu được các kiểu lập trình sự kiện trong Android2",BT4.class);
        ContentBt bt5 = new ContentBt("BT5","Thực hành và hiểu được AlertDialog",BT5.class);
        ContentBt bt6 = new ContentBt("BT6"," TextView, EditText,Button",BT6Edit_View_Buttom.class);
        ContentBt bt7 = new ContentBt("BT7","TextView, EditText, Button, Checkbox,RadioButton", BT7.class);
        ContentBt bt8= new ContentBt("BT8","ListView",BT8.class);
        ContentBt bt9= new ContentBt("BT9","ListView 2", BT9.class);
        ContentBt bt10= new ContentBt("BT10","Custom ListView, Cách kế thừaArrayAdapte", BT10.class);
        ContentBt bt11= new ContentBt("BT11","Spinner, Kết hợp Spinner,ListView", BT11.class);
        listTask.add(bt1);
        listTask.add(bt2);
        listTask.add(bt3);
        listTask.add(bt4);
        listTask.add(bt5);
        listTask.add(bt6);
        listTask.add(bt7);
        listTask.add(bt8);
        listTask.add(bt9);
        listTask.add(bt10);
        listTask.add(bt11);
        BaiTapAdapter adapter= new BaiTapAdapter(this,listTask);
        taskListView.setAdapter(adapter);
        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Class<?> selectedActivity = listTask.get(i).getActivity();
                Intent it = new Intent(MainActivity.this,selectedActivity);
                startActivity(it);
            }
        });
    }
}