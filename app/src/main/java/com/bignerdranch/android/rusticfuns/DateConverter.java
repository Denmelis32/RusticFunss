package com.bignerdranch.android.rusticfuns;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by dmelechow on 8/14/2019.
 */
public class DateConverter {

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}