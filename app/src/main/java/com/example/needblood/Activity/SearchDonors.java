package com.example.needblood.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.needblood.R;
import com.example.needblood.daos.DonorDao;
import com.example.needblood.daos.UserDao;
import com.example.needblood.database.DonorDatabase;
import com.example.needblood.database.UserDatabase;
import com.example.needblood.entities.Donor;
import com.example.needblood.entities.User;

import java.util.Locale;

public class SearchDonors extends AppCompatActivity {


    public void locationClick(View view) {
        Uri uri = Uri.parse("https://www.google.com/maps/@7.857685,80.70625,7z");
        Intent it = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }


    public static final String EXTRA_NAME=
            "com.example.needblood.EXTRA_NAME";
    public static final String EXTRA_CITY=
            "com.example.needblood.EXTRA_DESCRIPTION";
    public static final String EXTRA_BLOODGROUP=
            "com.example.needblood.EXTRA_BLOODGROUP";


    private EditText editTextName;
    private EditText editTextCity;
    private EditText editTextBloodGroup;
    private Button BnSave;

    private DonorDao donorDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_donors);

        editTextName = findViewById(R.id.editTextName);
        editTextCity = findViewById(R.id.editTextCity);
        editTextBloodGroup = findViewById(R.id.editTextBloodGroup);
        BnSave = findViewById(R.id.findDonor);

        donorDao = Room.databaseBuilder(this, DonorDatabase.class, "mi-database.db").allowMainThreadQueries()
                .build().donorDao();

        BnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String name = editTextName.getText().toString().trim();
                String city = editTextCity.getText().toString().trim();
                String bloodGroup = editTextBloodGroup.getText().toString().trim();


                Donor donor = new Donor(name, city, bloodGroup);
                donorDao.insert(donor);
                Intent moveToResult = new Intent(SearchDonors.this,SearchDonorResult.class);
                startActivity(moveToResult);

                Intent data = new Intent();
                data.putExtra(EXTRA_NAME, name);
                data.putExtra(EXTRA_CITY, city);
                data.putExtra(EXTRA_BLOODGROUP, bloodGroup);

                setResult(RESULT_OK, data);
                finish();

            }

        });
    }
}













