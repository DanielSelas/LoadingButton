package com.example.loadingbutton;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LoadingButton buttonSimple;
    private LoadingButton buttonUpload;
    private LoadingButton buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSimple = findViewById(R.id.buttonSimple);
        buttonUpload = findViewById(R.id.buttonUpload);
        buttonLogin = findViewById(R.id.buttonLogin);

        setupButtons();
    }

    private void setupButtons() {
        buttonSimple.setOnClickListener(v -> {
            buttonSimple.setLoadingText("Loading...");
            buttonSimple.setLoadingColor(R.color.pastel_green);
            simulateLoading(buttonSimple, 2000);
        });

        buttonUpload.setOnClickListener(v -> {
            buttonUpload.setLoadingText("Uploading...");
            buttonUpload.setLoadingColor(R.color.pastel_blue);
            simulateLoading(buttonUpload, 3000);
        });

        buttonLogin.setOnClickListener(v -> {
            buttonLogin.setLoadingText("Signing In...");
            buttonLogin.setLoadingColor(R.color.pastel_purple);
            simulateLoading(buttonLogin, 4000);
        });
    }

    private void simulateLoading(LoadingButton button, int durationMillis) {
        button.showLoading();

        new Handler(Looper.getMainLooper()).postDelayed(button::hideLoading, durationMillis);
    }
}