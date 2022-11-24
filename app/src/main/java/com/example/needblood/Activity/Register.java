package com.example.needblood.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.needblood.R;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void pressedRECIPIENTButton(View view){
        Intent intent1= new Intent(this,RegRecipient.class);
        startActivity(intent1);
    }

    public void pressedDONORButton(View view) {
        Intent intent2 = new Intent(this,RegDonor.class);
        startActivity(intent2);
    }
}