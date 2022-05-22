package com.example.mothercompanyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddOneChickenActivity extends AppCompatActivity {

    private Api api;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_one_chicken);
        EditText edtChickenId = findViewById(R.id.edt_chickenId);
        api = RetrofitClientInstance.getRetrofitInstance().create(Api.class);
        pDialog = new ProgressDialog(AddOneChickenActivity.this);
        pDialog.setMessage("Loading...");
        findViewById(R.id.btn_insert).setOnClickListener(v -> {
            pDialog.show();
            ChickenAsset chicken = new ChickenAsset(
                    edtChickenId.getText().toString().trim(),
                    "",
                    "",
                    "Zarbal",
                    "",
                    "Zarbal"
            );
            Call<RequestResponse> call = api.addchicken(chicken);
            call.enqueue(new Callback<RequestResponse>() {
                @Override
                public void onResponse(Call<RequestResponse> call, Response<RequestResponse> response) {
                    pDialog.dismiss();
                    Toast.makeText(AddOneChickenActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    finish();
                }

                @Override
                public void onFailure(Call<RequestResponse> call, Throwable t) {
                    pDialog.dismiss();
                    String err = "Something went wrong...Please try later!";
                    Toast.makeText(AddOneChickenActivity.this, err, Toast.LENGTH_LONG).show();
                    Log.d("my log", t.getMessage());
                    finish();
                }
            });
        });
    }
}