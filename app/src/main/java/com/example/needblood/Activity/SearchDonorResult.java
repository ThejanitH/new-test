package com.example.needblood.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.needblood.R;
import com.example.needblood.entities.Donor;
import com.example.needblood.models.DonorViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class SearchDonorResult extends AppCompatActivity {

    public static final int ADD_DONOR_REQUEST = 1;
    private DonorViewModel donorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_donor_result);



        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final DonorListAdapter adapter = new DonorListAdapter();
        recyclerView.setAdapter(adapter);



        donorViewModel = new ViewModelProvider(this).get(DonorViewModel.class);
        donorViewModel.getAllDonors().observe(this, new Observer<List<Donor>>() {
            @Override
            public void onChanged(List<Donor> donor){
                adapter.setDonor(donor);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_DONOR_REQUEST && resultCode == RESULT_OK) {
            String name = data.getStringExtra(SearchDonors.EXTRA_NAME);
            String city = data.getStringExtra(SearchDonors.EXTRA_CITY);
            String bloodGroup = data.getStringExtra(SearchDonors.EXTRA_BLOODGROUP);

            Donor donor = new Donor(name, city, bloodGroup);
            donorViewModel.insert(donor);

            Toast.makeText(this, "Donor saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Donor not saved", Toast.LENGTH_SHORT).show();
        }
    }


}