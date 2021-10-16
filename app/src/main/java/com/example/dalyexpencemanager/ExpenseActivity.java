package com.example.dalyexpencemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExpenseActivity extends AppCompatActivity {

    private EditText amountEt,dateEt,noteEt;
    private Button saveBt,loadBt;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        getSupportActionBar().setTitle("Today Expenses");

        //back button use jnno
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        init();

        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount= amountEt.getText().toString();
                String date= dateEt.getText().toString();
                String note= noteEt.getText().toString();

                if (amount.equals("")){
                    amountEt.setError("Please enter amount");
                    amountEt.requestFocus();
                    return;
                }
                if (date.equals("")){
                    dateEt.setError("Please enter date");
                    dateEt.requestFocus();
                    return;
                }
                if (note.equals("")){
                    noteEt.setError("Please enter note");
                    noteEt.requestFocus();
                    return;
                }

                ExpensesModel model=new ExpensesModel(amount,date,note);
                long rowId=dbHelper.ExpensesUser(model);

                if (rowId>0){
                    Toast.makeText(ExpenseActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ExpenseActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loadBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ExpenseActivity.this,ExpensesView.class);
                startActivity(intent);
            }
        });

    }

    public void init(){
        amountEt=findViewById(R.id.Amount_et);
        dateEt=findViewById(R.id.Date_et);
        noteEt=findViewById(R.id.Note_et);

        saveBt=findViewById(R.id.SaveId);
        loadBt=findViewById(R.id.LoadId);
        dbHelper=new DBHelper(ExpenseActivity.this);
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