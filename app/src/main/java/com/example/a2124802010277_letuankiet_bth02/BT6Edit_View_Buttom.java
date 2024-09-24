package com.example.a2124802010277_letuankiet_bth02;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BT6Edit_View_Buttom extends AppCompatActivity {

    EditText edtSolarYear;
    Button btnConvert;
    TextView txtLunarYear;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bt6_edit_view_buttom);

        edtSolarYear=findViewById(R.id.edtSolarYear);
        btnConvert=findViewById(R.id.btnConvert);
        txtLunarYear=findViewById(R.id.txtLunarYear);
        String[] can={"Canh","Tân","Nhâm","Quý","Giáp","Ất","Bính","Đinh","Mậu","Kỷ"};
        String[] chi={"Thân","Dậu","Tuất","Hợi","Tý","Sửu","Dần","Mão","Thìn","Tỵ","Ngọ","Mùi"};
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer Year=Integer.parseInt(edtSolarYear.getText().toString());
                Integer canI=Year%10;
                Integer chiI=Year%12;
                txtLunarYear.setText(can[canI]+" "+chi[chiI]);
            }
        });
    }
}