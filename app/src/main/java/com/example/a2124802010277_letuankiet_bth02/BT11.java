package com.example.a2124802010277_letuankiet_bth02;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class BT11 extends AppCompatActivity {
    Spinner spinnerProducts;
    ListView listView;
    ArrayList<String> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bt11);
        spinnerProducts = findViewById(R.id.spinner_products);
        listView = findViewById(R.id.listView);

        String[] arryLocal= getResources().getStringArray(R.array.moblie);
        products = new ArrayList<>(new ArrayList<>(Arrays.asList(arryLocal)));
        LocalationAdapter adapter1 = new LocalationAdapter(this, products);
        listView.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.products_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProducts.setAdapter(adapter);
        spinnerProducts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedProduct = adapterView.getItemAtPosition(i).toString();
                Log.d("Test", "onItemSelected: "+selectedProduct);
                if(selectedProduct.equals("Đồng Hồ"))
                {
                    String[] arryLocal1= getResources().getStringArray(R.array.watch);
                    products.clear();
                    products.addAll(Arrays.asList(arryLocal1));
                    adapter1.notifyDataSetChanged();
                }
                else if(selectedProduct.equals("Máy Tính"))
                {
                    String[] arryLocal1= getResources().getStringArray(R.array.laptop);
                    products.clear();
                    products.addAll(Arrays.asList(arryLocal1));
                    adapter1.notifyDataSetChanged();
                }
                else
                {
                    String[] arryLocal1= getResources().getStringArray(R.array.moblie);
                    products.clear();
                    products.addAll(Arrays.asList(arryLocal1));
                    adapter1.notifyDataSetChanged();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}