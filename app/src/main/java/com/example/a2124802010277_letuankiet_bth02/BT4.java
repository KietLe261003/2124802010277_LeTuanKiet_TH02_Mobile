package com.example.a2124802010277_letuankiet_bth02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BT4 extends AppCompatActivity {
    Button btnFrenheit,btnCelius,btnClear;
    EditText edtCelius,edtFrenheit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bt4);
        btnFrenheit=findViewById(R.id.btnFrenheit);
        btnCelius=findViewById(R.id.btnCelius);
        btnClear=findViewById(R.id.btnClear);
        edtCelius=findViewById(R.id.edtCelius);
        edtFrenheit=findViewById(R.id.edtFahrenheit);
        btnCelius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fahrenheitText = edtFrenheit.getText().toString();
                if (!fahrenheitText.isEmpty()) {
                    try {
                        double fahrenheit = Double.parseDouble(fahrenheitText);
                        double celsius = (fahrenheit - 32) * 5 / 9;
                        edtCelius.setText(String.valueOf(celsius));
                    } catch (NumberFormatException e) {
                        Toast.makeText(BT4.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(BT4.this, "Vui lòng nhập giá trị Fahrenheit", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Sự kiện khi nhấn nút chuyển đổi từ Fahrenheit sang Celsius
        btnFrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusText = edtCelius.getText().toString();
                if (!celsiusText.isEmpty()) {
                    try {
                        double celsius = Double.parseDouble(celsiusText);
                        double fahrenheit = (celsius * 9 / 5) + 32;
                        edtFrenheit.setText(String.valueOf(fahrenheit));
                    } catch (NumberFormatException e) {
                        Toast.makeText(BT4.this, "Vui lòng nhập số hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(BT4.this, "Vui lòng nhập giá trị Celsius", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Sự kiện khi nhấn nút Clear
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCelius.setText("");
                edtFrenheit.setText("");
            }
        });
    }
}