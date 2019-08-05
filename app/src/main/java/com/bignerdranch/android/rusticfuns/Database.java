package com.bignerdranch.android.rusticfuns;

/**
 * Created by dmelechow on 8/5/2019.
 */
@interface Database {
    Class<Person>[] entities();
    Person.AppDatabase db = Room.databaseBuilder(getApplicationContext(),
            Person.AppDatabase.class, "populus-database").build();
    int version();
}
