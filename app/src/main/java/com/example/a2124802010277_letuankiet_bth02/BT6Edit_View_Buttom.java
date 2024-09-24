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
    Button changeText;
    TextView simpleTextView;
    private Button btnReg;
    private TextView txtShowMessage;
    private EditText edtName, edtPassword, edtBirthday, edtEmail;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bt6_edit_view_buttom);

        //Cấu hình biến
        changeText=findViewById(R.id.btnChangeText);
        simpleTextView=findViewById(R.id.simpleTextView);


        //Xử lý
        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                simpleTextView.setText("Sau khi click vào");
            }
        });
        edtName		=	(EditText)findViewById(R.id.edtName);
        edtPassword	=	(EditText)findViewById(R.id.edtPassword);
        edtBirthday	=	(EditText)findViewById(R.id.edtBirthday);
        edtEmail	=	(EditText)findViewById(R.id.edtEmail);
        txtShowMessage=	(TextView)findViewById(R.id.txtShowMessage);
        btnReg		=	(Button)findViewById(R.id.btnReg);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String str="Thông tin tài khoản \n";
                str+="Tài Khoản:"+edtName.getText().toString()+"\n Mật khẩu:"+edtPassword.getText().toString();
                str+="\nNgày sinh: "+edtBirthday.getText().toString()+"\nEmail:"+edtEmail.getText().toString();
                txtShowMessage.setText(str);
                txtShowMessage.setBackgroundColor(Color.GREEN);
            }
        });

    }
}