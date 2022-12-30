package com.example.needblood.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.needblood.entities.Donor;
import com.example.needblood.repositories.DonorRepository;

import java.util.List;

public class DonorViewModel extends AndroidViewModel {
    private DonorRepository repository;
    private LiveData<List<Donor>> allDonors;


    public DonorViewModel(@NonNull Application application) {
        super(application);
        repository=new DonorRepository(application);
        allDonors= repository.getAllDonors();
    }

    public void insert(Donor donor){
        repository.insert(donor);
    }

    public void deleteAllDonors(){
        repository.deleteAllDonors();
    }

    public LiveData<List<Donor>> getAllDonors() {
        return allDonors;
    }

}
