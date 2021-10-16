package com.example.dalyexpencemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper  {

    static final String DATABASE_NAME="student_db";
    static final int VERSION = 10;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Registration page
        String CREATE_USER_TABLE= "create table "+DatabaseContact.User.USER_TABLE+
                " ( "+DatabaseContact.User.USER_ID+
                " integer primary key autoincrement , "+
                DatabaseContact.User.USER_NAME+" text, "+
                DatabaseContact.User.USER_EMAIL+" text, "+
                DatabaseContact.User.USER_PASSWORD+" text "+
                ")";

        //Income page
        String CREATE_USER="create table "+ DatabaseContact.IncomeTable.INCOME+
                " ( "+ DatabaseContact.IncomeTable.ID+
                " integer primary key autoincrement ,"+
                DatabaseContact.IncomeTable.USER_INCOME+" text ,"+
                DatabaseContact.IncomeTable.INCOME_DATE+" text ,"+
                DatabaseContact.IncomeTable.USER_NOTE+" text )";

        //Expenses page
        String CREATE_EXPENSES_TABLE= "create table "+DatabaseContact.ExpensesTable.EXPENSES+
                " ( "+DatabaseContact.ExpensesTable.ID+
                " integer primary key autoincrement ,"+
                DatabaseContact.ExpensesTable.AMOUNT_EXPENSES+" text ,"+
                DatabaseContact.ExpensesTable.EXPENSES_DATE+" text ,"+
                DatabaseContact.ExpensesTable.EXPENSES_NOTE+" text )";



        //Registration paige
        db.execSQL(CREATE_USER_TABLE);
        //Income paige
        db.execSQL(CREATE_USER);
        //Expenses paige
        db.execSQL(CREATE_EXPENSES_TABLE);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+DatabaseContact.User.USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+ DatabaseContact.IncomeTable.INCOME);
        db.execSQL("DROP TABLE IF EXISTS "+DatabaseContact.ExpensesTable.EXPENSES);
        onCreate(db);


    }


    public int loginUser(String email, String password){
     SQLiteDatabase db = getWritableDatabase();
     Cursor cursor= db.rawQuery("SELECT * FROM "+DatabaseContact.User.USER_TABLE+" WHERE "+DatabaseContact.User.USER_EMAIL+" =? and "+DatabaseContact.User.USER_PASSWORD+" =? " ,new String[]{email,password});
     int value = cursor.getCount();
     return value;
    }

    //Registration paige
    public long insertUser(UserModel model){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseContact.User.USER_NAME,model.getName());
        contentValues.put(DatabaseContact.User.USER_EMAIL,model.getEmail());
        contentValues.put(DatabaseContact.User.USER_PASSWORD,model.getPassword());
        long rowId = db.insert(DatabaseContact.User.USER_TABLE,null,contentValues);
        return rowId;
    }
    //Income page
    public long insertUser2(IncomeModel model){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(DatabaseContact.IncomeTable.USER_INCOME,model.getAmount());
        cv.put(DatabaseContact.IncomeTable.INCOME_DATE,model.getDate());
        cv.put(DatabaseContact.IncomeTable.USER_NOTE,model.getNote());

        long rowId= db.insert(DatabaseContact.IncomeTable.INCOME,null,cv);
        return rowId;

    }

    //Expenses page
    public long ExpensesUser(ExpensesModel model){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(DatabaseContact.ExpensesTable.AMOUNT_EXPENSES,model.getAmount());
        cv.put(DatabaseContact.ExpensesTable.EXPENSES_DATE,model.getDate());
        cv.put(DatabaseContact.ExpensesTable.EXPENSES_NOTE,model.getNote());

        long rowId= db.insert(DatabaseContact.ExpensesTable.EXPENSES,null,cv);
        return rowId;
    }

    public ArrayList<IncomeModel>getAllUserList(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<IncomeModel>list= new ArrayList<>();

        Cursor cursor=db.rawQuery("select * from "+ DatabaseContact.IncomeTable.INCOME,null);

        if (cursor.moveToFirst()){
            do {

                String income=cursor.getString(cursor.getColumnIndex(DatabaseContact.IncomeTable.USER_INCOME));
                String date=cursor.getString(cursor.getColumnIndex(DatabaseContact.IncomeTable.INCOME_DATE));
                String note=cursor.getString(cursor.getColumnIndex(DatabaseContact.IncomeTable.USER_NOTE));
                IncomeModel model= new IncomeModel(income,date,note);

                list.add(model);
            }while (cursor.moveToNext());

        }
        return list;
    }

    public ArrayList<ExpensesModel>getAllExpensesList(){
        SQLiteDatabase db= getWritableDatabase();
        ArrayList<ExpensesModel>list= new ArrayList<>();

        Cursor cursor= db.rawQuery("select * from "+DatabaseContact.ExpensesTable.EXPENSES,null);

        if (cursor.moveToFirst()){
            do {
                String amount=cursor.getString(cursor.getColumnIndex(DatabaseContact.ExpensesTable.AMOUNT_EXPENSES));
                String date=cursor.getString(cursor.getColumnIndex(DatabaseContact.ExpensesTable.EXPENSES_DATE));
                String note=cursor.getString(cursor.getColumnIndex(DatabaseContact.ExpensesTable.EXPENSES_NOTE));
                ExpensesModel model = new ExpensesModel(amount,date,note);

                list.add(model);
            }while (cursor.moveToNext());
        }
        return list;
    }


}
