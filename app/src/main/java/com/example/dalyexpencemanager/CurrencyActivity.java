package com.example.dalyexpencemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CurrencyActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        listView=findViewById(R.id.list_currency_id);
        textView=findViewById(R.id.currency_id);

       String[] CurrencyName = getResources().getStringArray(R.array.Currency_name);

       /* ArrayAdapter<String> adapter= new ArrayAdapter<String>(CurrencyActivity.this,R.layout.text_currency,R.id.text_id,CurrencyName);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = CurrencyName[position];
                Toast.makeText(CurrencyActivity.this,value+ ""+position, Toast.LENGTH_SHORT).show();


            }
        });*/
    }
}