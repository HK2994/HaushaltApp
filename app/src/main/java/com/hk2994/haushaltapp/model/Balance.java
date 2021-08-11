package com.hk2994.haushaltapp.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Balance class
 * */
public class Balance {

    private int amount;
    private final Date date;
    private String description;

    public Balance(int amount) {
        this.amount = amount;
        this.date =  new Date();
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDateString() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.GERMANY).format(this.date);
    }

    public String toString() {
        return getDateString() + ": " + amount + "€";
    }
}
