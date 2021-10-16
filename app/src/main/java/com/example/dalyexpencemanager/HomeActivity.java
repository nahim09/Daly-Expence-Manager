package com.example.dalyexpencemanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView cardViewIncome,cardViewExpense,cardViewSetting,cardViewAbout,cardViewShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setTitle("Daily Expenses Manager");

        //back button use jnno
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        cardViewIncome = findViewById(R.id.income_id);
        cardViewExpense = findViewById(R.id.expense_id);
        cardViewSetting = findViewById(R.id.setting_id);
        cardViewAbout = findViewById(R.id.about_id);
        cardViewShare = findViewById(R.id.share_id);

        cardViewIncome.setOnClickListener(this);
        cardViewExpense.setOnClickListener(this);
        cardViewSetting.setOnClickListener(this);
        cardViewAbout.setOnClickListener(this);
        cardViewShare.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        if (v.getId()==R.id.income_id){
            Intent intent = new Intent(HomeActivity.this,IncomeActivity.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.expense_id){
            Intent intent = new Intent(HomeActivity.this,ExpenseActivity.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.setting_id){
            Intent intent = new Intent(HomeActivity.this,SettingActivity.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.about_id){
            Intent intent = new Intent(HomeActivity.this,AboutActivity.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.share_id){
            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String shareBody = "Your body here";
            String shareSub = "Your Subject here";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
            myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
            startActivity(Intent.createChooser(myIntent, "Share using"));
        }

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