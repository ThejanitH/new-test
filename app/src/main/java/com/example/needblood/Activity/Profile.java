package com.example.needblood.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.needblood.R;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    public void pressedSearchDonorsButton(View view) {
        Intent intent1 = new Intent(this, SearchDonors.class);
        startActivity(intent1);
    }
    public void pressedPostReqButton(View view) {
        Intent intent2 = new Intent(this, PostReq.class);
        startActivity(intent2);
    }
}
