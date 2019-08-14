package com.bignerdranch.android.rusticfuns;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

/**
 * Created by dmelechow on 8/13/2019.
 */
@Entity
class MilkDeliver {


    @PrimaryKey(autoGenerate = true)
    public  int id;
    private double theNumbeOfLitersOfMilk;
    @TypeConverters({DateConverter.class})
    private Date date;
    private double milkPrice;

    public double getMilkPrice() {
        return milkPrice;
    }

    public void setMilkPrice(double milkPrice) {
        this.milkPrice = milkPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public double getTheNumbeOfLitersOfMilk() {
        return theNumbeOfLitersOfMilk;
    }

    public void setTheNumbeOfLitersOfMilk(double theNumbeOfLitersOfMilk) {
        this.theNumbeOfLitersOfMilk = theNumbeOfLitersOfMilk;
    }

}
