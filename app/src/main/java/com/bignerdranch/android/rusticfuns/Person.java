package com.bignerdranch.android.rusticfuns;

/**
 * Created by dmelechow on 8/4/2019.
 */

@Entity

public class Person{
    @PrimaryKey String name;
    int age;
    String favoriteColor;

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Database(entities = {Person.class }, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract PersonDao getPersonDao();
    }
}


