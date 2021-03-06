package com.example.uaslalumena;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btnKucing,btnAnjing,btnUlar;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }
    private void inisialisasiView() {
        btnKucing = findViewById(R.id.btn_buka_ras_kucing);
        btnAnjing = findViewById(R.id.btn_buka_ras_anjing);
        btnUlar = findViewById(R.id.btn_buka_ras_ular);
        btnKucing.setOnClickListener(view -> bukaGaleri("Cat"));
        btnAnjing.setOnClickListener(view -> bukaGaleri("Dog"));
        btnUlar.setOnClickListener(view -> bukaGaleri("Snake"));
    }

    private void bukaGaleri(String jenisHewan) {
        Log.d("MAIN","Buka activity kucing");
        Intent intent = new Intent(this, HewanActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisHewan);
        startActivity(intent);
    }

    public void Pindah(View view) {
        Intent intent = new Intent(MainActivity.this, Profile.class);
        startActivity(intent);
    }
}