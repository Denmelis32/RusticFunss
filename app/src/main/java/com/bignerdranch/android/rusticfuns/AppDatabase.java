package com.bignerdranch.android.rusticfuns;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

/**
 * Created by dmelechow on 8/13/2019.
 */
@Database(entities = {MilkDeliver.class }, version = 1)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract   MilkDao getMilkDao();
}