package com.bignerdranch.android.rusticfuns;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.List;

/**
 * Created by dmelechow on 8/13/2019.
 */
@Dao
@TypeConverters({DateConverter.class})
public interface MilkDao {
    @Insert
    void insertAll(MilkDeliver... people);

    // Удаление Person из бд
    @Delete
    void delete(MilkDeliver milkDeliver);

    // Получение всех Person из бд
    @Query("SELECT * FROM milkdeliver")
    List<MilkDeliver> getAllPmilk();


}
