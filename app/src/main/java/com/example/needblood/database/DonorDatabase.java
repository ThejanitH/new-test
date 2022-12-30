package com.example.needblood.database;


import android.content.AsyncQueryHandler;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.needblood.daos.DonorDao;
import com.example.needblood.entities.Donor;

@Database(entities = {Donor.class}, version = 1,exportSchema=false)
public abstract class DonorDatabase extends RoomDatabase {
    public abstract DonorDao donorDao();
    private static DonorDatabase INSTANCE;

    public static DonorDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DonorDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    DonorDatabase.class, "donor_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomDatabaseCallback=new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {
        private final DonorDao donorDao;

        PopulateDbAsync(DonorDatabase db){
            donorDao=db.donorDao();
        }


        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }

}
