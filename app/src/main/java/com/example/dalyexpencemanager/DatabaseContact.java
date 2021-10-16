package com.example.dalyexpencemanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseContact  {

    public static class User{
        public static final String USER_TABLE="user_table";
        public static final String USER_NAME="user_name";
        public static final String USER_ID="user_id";
        public static final String USER_EMAIL="user_email";
        public static final String USER_PASSWORD="user_password";
    }
    public static class IncomeTable {
        public static final String INCOME="income_table";
        public static final String USER_INCOME="_income";
        public static final String ID="id";
        public static final String INCOME_DATE="_date";
        public static final String USER_NOTE="_note";
    }
    public static class ExpensesTable{
        public static final String EXPENSES="expenses_table";
        public static final String AMOUNT_EXPENSES="_expenses";
        public static final String ID="expenses_id";
        public static final String EXPENSES_DATE="expenses_date";
        public static final String EXPENSES_NOTE="expenses_note";
    }
}
