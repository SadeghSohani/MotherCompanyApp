package com.example.mothercompanyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNumbers;
    private Button btnProduce, btnGetAll;
    private RecyclerView recycler;
    private CustomAdapter adapter;
    private ProgressDialog pDialog;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumbers = findViewById(R.id.edt_number);
        btnProduce = findViewById(R.id.btn_produce);
        btnGetAll = findViewById(R.id.btn_getAll);
        recycler = findViewById(R.id.recycler);
        btnProduce.setOnClickListener(this);
        btnGetAll.setOnClickListener(this);
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Loading...");
        api = RetrofitClientInstance.getRetrofitInstance().create(Api.class);

        findViewById(R.id.fab).setOnClickListener(v -> {
            startActivity(new Intent(this, AddOneChickenActivity.class));
        });


    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_produce: {
                pDialog.show();
                RequestBody body = new RequestBody(Integer.valueOf(edtNumbers.getText().toString().trim()));
                Call<RequestResponse> call = api.initLedger(body);
                call.enqueue(new Callback<RequestResponse>() {
                    @Override
                    public void onResponse(Call<RequestResponse> call, Response<RequestResponse> response) {
                        pDialog.dismiss();
                        Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                    @Override
                    public void onFailure(Call<RequestResponse> call, Throwable t) {
                        pDialog.dismiss();
                        String err = "Something went wrong...Please try later!";
                        Toast.makeText(MainActivity.this, err, Toast.LENGTH_LONG).show();
                        Log.d("my log", t.getMessage());
                    }
                });
                break;
            }
            case R.id.btn_getAll: {
                pDialog.show();
                Call<List<ChickenAsset>> call = api.getAllChickens();
                call.enqueue(new Callback<List<ChickenAsset>>() {
                    @Override
                    public void onResponse(Call<List<ChickenAsset>> call, Response<List<ChickenAsset>> response) {
                        pDialog.dismiss();
                        generateDataList(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<ChickenAsset>> call, Throwable t) {
                        pDialog.dismiss();
                        String err = "Something went wrong...Please try later!";
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
                break;
            }
        }
    }

    private void generateDataList(List<ChickenAsset> datList) {
        adapter = new CustomAdapter(this, datList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);
    }

}