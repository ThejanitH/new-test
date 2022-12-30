package com.example.needblood.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.needblood.R;
import com.example.needblood.daos.UserDao;
import com.example.needblood.database.UserDatabase;
import com.example.needblood.entities.User;

public class RegDonor extends AppCompatActivity {

    EditText editTextName, editTextAge,editTextWeight,editTextCity,editTextContactNo,editTextBloodGroup,editTextEmail,editTextUsername,editTextPassword;
    Button buttonRegister;

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_donor);

        editTextName = findViewById(R.id.editTextDName);
        editTextAge = findViewById(R.id.editTextDAge);
        editTextWeight = findViewById(R.id.editTextDWeight);
        editTextCity = findViewById(R.id.editTextDCity);
        editTextContactNo = findViewById(R.id.editTextDContactNo);
        editTextBloodGroup = findViewById(R.id.editTextDBloodGroup);
        editTextEmail = findViewById(R.id.editTextDEmail);
        editTextUsername = findViewById(R.id.editTextDUsername);
        editTextPassword = findViewById(R.id.editTextDPassword);
        buttonRegister = findViewById(R.id.Dregbutton);


        userDao = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String age = editTextAge.getText().toString().trim();
                String weight = editTextWeight.getText().toString().trim();
                String city = editTextCity.getText().toString().trim();
                String contactNo = editTextContactNo.getText().toString().trim();
                String bloodGroup= editTextBloodGroup.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String userName = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (TextUtils.isEmpty(userName)) {
                    editTextUsername.setError("UserName is Required.");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    editTextEmail.setError("Email is Required.");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    editTextPassword.setError("Password is Required");
                    return;
                }

                User user = new User(name,age,weight,city,contactNo,bloodGroup,email,userName,password);
                userDao.insert(user);
                Intent moveToMain = new Intent(RegDonor.this, MainActivity.class);
                startActivity(moveToMain);

            }
        });

    }


}