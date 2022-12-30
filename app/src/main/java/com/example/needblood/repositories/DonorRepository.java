package com.example.needblood.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.needblood.daos.DonorDao;
import com.example.needblood.database.DonorDatabase;
import com.example.needblood.entities.Donor;

import java.util.List;

public class DonorRepository {
    private DonorDao donorDao;
    private LiveData<List<Donor>> allDonors;

    public DonorRepository(Application application) {
        DonorDatabase db = DonorDatabase.getDatabase(application);
        donorDao = db.donorDao();
        allDonors = donorDao.getAllDonors();
    }

    public LiveData<List<Donor>> getAllDonors() {
        return allDonors;
    }

    public void insert(Donor donor){
        new InsertDonorAsyncTask(donorDao).execute(donor);
    }



    public void deleteAllDonors(){
        new DeleteAllDonorAsyncTask(donorDao).execute();

    }

    private static class InsertDonorAsyncTask extends AsyncTask<Donor,Void,Void> {
        private DonorDao donorDao;

        private InsertDonorAsyncTask(DonorDao donorDao){
            this.donorDao=donorDao;
        }

        @Override
        protected Void doInBackground(Donor...donor){
            donorDao.insert(donor[0]);
            return null;
        }

    }
    private static class DeleteAllDonorAsyncTask extends AsyncTask<Void,Void,Void> {
        private DonorDao donorDao;

        private DeleteAllDonorAsyncTask(DonorDao noteDao){
            this.donorDao=noteDao;
        }

        @Override
        protected Void doInBackground(Void...voids){
            donorDao.deleteAllDonors();
            return null;
        }

    }
}
