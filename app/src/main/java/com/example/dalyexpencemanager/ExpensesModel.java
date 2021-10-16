package com.example.dalyexpencemanager;

public class ExpensesModel {

    private String amount,date,note;

    public ExpensesModel(String amount, String date, String note) {
        this.amount = amount;
        this.date = date;
        this.note = note;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
