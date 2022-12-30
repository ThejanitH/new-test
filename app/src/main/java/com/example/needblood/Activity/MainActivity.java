package com.example.needblood.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.needblood.R;
import com.example.needblood.daos.UserDao;
import com.example.needblood.database.UserDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    Button buttonLogin;
    TextView textViewRegister;
    UserDao db;
    UserDatabase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextUsername = findViewById(R.id.editTextDUsername);
        editTextPassword = findViewById(R.id.editTextDPassword);
        buttonLogin = findViewById(R.id.loginButton);
        textViewRegister = findViewById(R.id.textViewRegister);

        dataBase = Room.databaseBuilder(this, UserDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.getUserDao();
}

    public void pressedLoginButton(View view){

        String userName = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(userName)) {
            editTextUsername.setError("UserName is Required.");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Password is Required");
            return;
        }

        Intent intent0 = new Intent(this,Profile.class);
        startActivity(intent0);
    }
    public void pressedSignUp(View view){
        Intent intent7 = new Intent(this,Register.class);
        startActivity(intent7);
    }
}