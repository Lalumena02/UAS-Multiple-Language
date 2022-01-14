package com.example.uaslalumena;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uaslalumena.model.Hewan;
import com.example.uaslalumena.model.Anjing;
import com.example.uaslalumena.model.Kucing;
import com.example.uaslalumena.model.Ular;


public class DetailHewan extends AppCompatActivity {
    Hewan hewan;
    TextView txJudul,txJenis,txAsal,txDeskripsi;
    ImageView ivFotoHewan;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_ras);
        Intent intent = getIntent();
        hewan = (Hewan) intent.getSerializableExtra(HewanActivity.HEWAN_TERPILIH);
        inisialisasiView();
        tampilkanProfil(hewan);
    }

    private void inisialisasiView() {
        txJudul = findViewById(R.id.txJudul);
        txJenis = findViewById(R.id.txJenis);
        txAsal = findViewById(R.id.txAsal);
        txDeskripsi = findViewById(R.id.txDeskripsi);
        ivFotoHewan = findViewById(R.id.gambarHewan);
        btnBack = findViewById(R.id.btn_back_to_list);
        btnBack.setOnClickListener(view -> {
            onBackPressed();
        });
    }


    private void tampilkanProfil(Hewan hewan) {
        Log.d("Profil","Menampilkan "+hewan.getJenis());
        if (hewan instanceof Kucing) {
            txJudul.setText(getString(R.string.kucing));
        } else if (hewan instanceof Ular) {
            txJudul.setText(getString(R.string.ular));
        } else if (hewan instanceof Anjing) {
            txJudul.setText(getString(R.string.anjing));
        }
        txJenis.setText(hewan.getRas());
        txAsal.setText(hewan.getAsal());
        txDeskripsi.setText(hewan.getDeskripsi());
        ivFotoHewan.setImageDrawable(this.getDrawable(hewan.getDrawableRes()));
    }
}
