package com.example.a2124802010277_letuankiet_bth02;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BT3 extends AppCompatActivity implements View.OnClickListener {
    TextView txtAnswer;
    EditText edtSoA,edtSoB;
    Button btnMinus,btnMultip,btnDivide,btnUCLN;
    private void caculator(String operation){
        txtAnswer=findViewById(R.id.txtAnswer);
        edtSoA=findViewById(R.id.edtSoA);
        edtSoB=findViewById(R.id.edtSoB);
        Integer a=Integer.parseInt(edtSoA.getText().toString());
        Integer b=Integer.parseInt(edtSoB.getText().toString());
        Integer ans=0;
        if(operation.equals("+"))
            ans=a+b;
        else if(operation.equals("-"))
            ans=a-b;
        else if(operation.equals("*"))
            ans=a*b;
        else if(operation.equals("/"))
        {
            Double a1=Double.parseDouble(edtSoA.getText().toString());
            Double b1=Double.parseDouble(edtSoB.getText().toString());
            Double ans1=a1/b1;
            txtAnswer.setText(ans1+"");
            return;
        }
        else{
            if(a==0 || b==0)
                ans=a+b;
            else
            {
                while(a!=b)
                {
                    if(a>b)
                        a-=b;
                    else
                        b-=a;
                }
                ans=b;
            }
        }
        txtAnswer.setText(ans+"");

    }
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bt3);
        // Cấu hình biến
        edtSoA=findViewById(R.id.edtSoA);
        edtSoB=findViewById(R.id.edtSoB);
        txtAnswer=findViewById(R.id.txtAnswer);
        btnMinus=findViewById(R.id.btnMinus);
        btnMultip=findViewById(R.id.btnMultips);
        btnDivide=findViewById(R.id.btnDivide);
        btnUCLN=findViewById(R.id.btnUCLN);

        //Xử lý
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caculator("-");
            }
        });
        btnMultip.setOnClickListener(this);
        btnDivide.setOnClickListener(divide);
        btnUCLN.setOnClickListener(new UCLN());
    }
    public void Sum2Number(View view){
        caculator("+");
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnMultips)
        {
            caculator("*");
        }
    }
    private final View.OnClickListener divide = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btnDivide) {
                caculator("/");
            }
        }
    };
    private class UCLN implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            caculator("UCLN");
        }
    }

}