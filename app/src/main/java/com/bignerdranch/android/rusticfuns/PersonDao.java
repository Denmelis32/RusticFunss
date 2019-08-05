package com.bignerdranch.android.rusticfuns;

import java.util.List;

/**
 * Created by dmelechow on 8/5/2019.
 */
@Dao
public interface PersonDao {
    @Insert
    void insertAll(Person... people);

    // Удаление Person из бд
    @Delete
    void delete(Person person);

    // Получение всех Person из бд
    @Query("SELECT * FROM person")
    List<Person> getAllPeople();

    // Получение всех Person из бд с условием
    @Query("SELECT * FROM person WHERE favoriteColor LIKE :color")
    List<Person> getAllPeopleWithFavoriteColor(String color);
}
