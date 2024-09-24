package com.example.a2124802010277_letuankiet_bth02;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BT7 extends AppCompatActivity {
    RadioGroup radioGroupDegree;
    RadioButton radioTrungCap, radioCaoDang, radioDaiHoc;
    CheckBox chkDocBao, chkDocSach, chkDocCoding;
    Button btnSubmit;
    EditText edtName, edtCMND , edtAdditionalInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bt7);
        edtName=findViewById(R.id.edtName);
        edtCMND=findViewById(R.id.edtCMND);
        edtAdditionalInfo=findViewById(R.id.edtAdditionalInfo);

        radioGroupDegree = findViewById(R.id.radioGroupDegree);
        radioTrungCap = findViewById(R.id.radioTrungCap);
        radioCaoDang = findViewById(R.id.radioCaoDang);
        radioDaiHoc = findViewById(R.id.radioDaiHoc);

        chkDocBao = findViewById(R.id.chkDocBao);
        chkDocSach = findViewById(R.id.chkDocSach);
        chkDocCoding = findViewById(R.id.chkDocCoding);
        btnSubmit=findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=edtName.getText().toString();
                String CMND=edtCMND.getText().toString();
                String AdditionalInfo=edtAdditionalInfo.getText().toString();
                String hobies="";
                String degree="Dai Hoc";

                if(name.isEmpty() || name.length()<=3)
                {
                    Toast.makeText(BT7.this, "Tên người dùng không hợp lệ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!CMND.matches("\\d{9}")) {
                    Toast.makeText(BT7.this, "CMND phải là số và có đúng 9 chữ số", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(radioGroupDegree.getCheckedRadioButtonId()==R.id.radioTrungCap)
                    degree="Trung Cap";
                else if(radioGroupDegree.getCheckedRadioButtonId()==R.id.radioCaoDang)
                    degree="Cao Dang";
                if(!chkDocSach.isChecked() && !chkDocBao.isChecked() && !chkDocCoding.isChecked())
                {
                    Toast.makeText(BT7.this, "Phải chọn ít nhất 1 sở thích", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(chkDocBao.isChecked())
                    hobies+=" Đọc Báo ";
                if(chkDocSach.isChecked())
                    hobies+=" Đọc Sách ";
                if(chkDocCoding.isChecked())
                    hobies+=" Đọc sách ";
                showInfoDialog(name, CMND, degree, hobies, AdditionalInfo);
            }
        });
    }
    private void showInfoDialog(String name, String cmnd, String degree, String hobbies, String additionalInfo) {
        // Tạo AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_user_info, null);
        builder.setView(dialogView);

        // Ánh xạ các view trong dialog
        TextView txtName = dialogView.findViewById(R.id.txtName);
        TextView txtCMND = dialogView.findViewById(R.id.txtCMND);
        TextView txtDegree = dialogView.findViewById(R.id.txtDegree);
        TextView txtHobbies = dialogView.findViewById(R.id.txtHobbies);
        TextView txtAdditionalInfo = dialogView.findViewById(R.id.txtAdditionalInfo);
        Button btnClose = dialogView.findViewById(R.id.btnClose);

        // Set thông tin vào các view
        txtName.setText(name);
        txtCMND.setText(cmnd);
        txtDegree.setText(degree);
        txtHobbies.setText(hobbies);
        txtAdditionalInfo.setText(additionalInfo);

        // Hiển thị dialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        // Xử lý sự kiện đóng dialog
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
}