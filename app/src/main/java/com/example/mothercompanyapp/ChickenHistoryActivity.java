package com.example.mothercompanyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ChickenHistoryActivity extends AppCompatActivity {

    private String chickenId, chickenFarm, feedingCompany, motherCompany, slaughterHouse, owner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicken_history);
        Intent intent = getIntent();
        chickenId = intent.getStringExtra("chickenId");
        chickenFarm = intent.getStringExtra("chickenFarm");
        feedingCompany = intent.getStringExtra("feedingCompany");
        motherCompany = intent.getStringExtra("motherCompany");
        slaughterHouse = intent.getStringExtra("slaughterHouse");
        owner = intent.getStringExtra("owner");

        TextView tvMotherCompany = findViewById(R.id.tv_motherCompany);
        TextView tvChickenFarm = findViewById(R.id.tv_chickenFarm);
        TextView tvFeedingCompany = findViewById(R.id.tv_feedingCompany);
        TextView tvSlaughterhouse = findViewById(R.id.tv_slaughterhouse);

        tvMotherCompany.append(motherCompany);
        tvChickenFarm.append(chickenFarm);
        tvSlaughterhouse.append(slaughterHouse);
        tvFeedingCompany.append(feedingCompany);

    }
}