package com.example.dalyexpencemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class IncomeActivity extends AppCompatActivity {

    private EditText amountEt,dateEt,noteEt;
    private Button saveBtn,loadBtn;
    //private RecyclerView recyclerView;
    private DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        getSupportActionBar().setTitle("Today Income");

        //back button use jnno
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

          initValue();


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount =amountEt.getText().toString();
                String date =dateEt.getText().toString();
                String note =noteEt.getText().toString();

                if(amount.equals("")){
                    amountEt.setError("Please enter amount");
                    amountEt.requestFocus();
                    return;
                }
                if(date.equals("")){
                    dateEt.setError("Please enter date");
                    dateEt.requestFocus();
                    return;
                }
                if(note.equals("")){
                    noteEt.setError("Please enter note");
                    noteEt.requestFocus();
                    return;
                }

                IncomeModel model=new IncomeModel(amount,date,note);
                long rowId=dbHelper.insertUser2(model);

                if (rowId>0){
                    Toast.makeText(IncomeActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(IncomeActivity.this, "fail", Toast.LENGTH_SHORT).show();
                }

            }
        });

        loadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(IncomeActivity.this,IncomeView.class);
                startActivity(intent);

                /*LinearLayoutManager manager= new LinearLayoutManager(IncomeActivity.this);
                manager.setOrientation(RecyclerView.VERTICAL);
                recyclerView.setLayoutManager(manager);
                ArrayList<IncomeModel> list=dbHelper.getAllUserList();
                UserAdapter adapter = new UserAdapter(IncomeActivity.this,list);
                recyclerView.setAdapter(adapter);*/

            }
        });



    }

    private void initValue() {
        amountEt=findViewById(R.id.amount_et);
        dateEt=findViewById(R.id.date_et);
        noteEt=findViewById(R.id.note_et);
        //recyclerView=findViewById(R.id.recyclerview);

        saveBtn=findViewById(R.id.saveId);
        loadBtn=findViewById(R.id.loadId);

        dbHelper=new DBHelper(IncomeActivity.this);
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