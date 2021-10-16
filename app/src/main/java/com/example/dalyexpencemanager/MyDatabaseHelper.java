package com.example.dalyexpencemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Registration.Information";
    private static final String TABLE_NAME = "Registration.Details";
    private static final String ID = "_id";
    private static final String NAME = "name";
    private static final String NUMBER = "number";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String CONFIRM_PASSWORD = "confirmPassword";
    private static final int VERSION_NUMBER = 3;

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ( "
            +ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +NAME+" TEXT,"
            +NUMBER+" TEXT, "
            +EMAIL+" TEXT, "
            +PASSWORD+" TEXT, "
            +CONFIRM_PASSWORD+" TEXT ); ";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME;

    private Context context;
    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Toast.makeText(context, "OnCreate is call", Toast.LENGTH_SHORT).show();
            db.execSQL(CREATE_TABLE);
        }catch (Exception e){
            Toast.makeText(context, "Exception"+e, Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Toast.makeText(context, "OnUpgrade is call", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);

        }catch (Exception e){
            Toast.makeText(context, "Exception"+e, Toast.LENGTH_SHORT).show();
        }

    }
    public long insertData(String name,String number,String email,String password,String confirmPassword){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(NUMBER,number);
        contentValues.put(EMAIL,email);
        contentValues.put(PASSWORD,password);
        contentValues.put(CONFIRM_PASSWORD,confirmPassword);
        long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowId;
    }
}
