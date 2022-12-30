package com.example.needblood.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.needblood.entities.Donor;

import java.util.List;

@Dao
public interface DonorDao {
    @Insert
    void insert(Donor donor);
    @Update
    void update(Donor donor);
    @Delete
    void delete(Donor donor);

    @Query("DELETE FROM donor_table")
    void deleteAllDonors();

    @Query("SELECT * FROM donor_table ")
    LiveData<List<Donor>> getAllDonors();
}