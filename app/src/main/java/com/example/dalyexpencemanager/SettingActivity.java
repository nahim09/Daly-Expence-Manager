package com.example.dalyexpencemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    private ListView listView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        getSupportActionBar().setTitle("Setting");

        //back button use jnno
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listView=findViewById(R.id.list_id);
        textView=findViewById(R.id.text_id);

        String[] SettingName = getResources().getStringArray(R.array.Setting_name);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(SettingActivity.this,R.layout.text_setting,R.id.text_id,SettingName);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Value = SettingName[position];

                Toast.makeText(SettingActivity.this,Value+ ""+position, Toast.LENGTH_SHORT).show();

                if(position==0){
                    Intent intent=new Intent(view.getContext(),CurrencyActivity.class);
                    startActivity(intent);
                }
                if(position==10){
                    Intent intent=new Intent(view.getContext(),RegistrationActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
    //back button use jnno
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}