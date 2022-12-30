package com.example.needblood.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.needblood.R;

public class RegRecipient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_recipient);
    }
    public void pressedBecomeReciButton(View view) {
        Intent intent5 = new Intent(this, MainActivity.class);
        startActivity(intent5);
    }

}