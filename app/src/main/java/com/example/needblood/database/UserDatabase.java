package com.example.needblood.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.needblood.daos.UserDao;
import com.example.needblood.entities.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

        public abstract UserDao getUserDao();

}

