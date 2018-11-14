package com.example.radit.hotcen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuPembayaran extends AppCompatActivity {

    private Button tunai,nonTunai;

    public menuPembayaran() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pembayaran);

        tunai = findViewById(R.id.tunai);
        nonTunai = findViewById(R.id.nontunai);
        tunai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuPembayaran.this,pembayaranTunai.class);
                startActivity(intent);
            }
        });
        nonTunai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menuPembayaran.this,pembayaranNonTunai.class);
                startActivity(intent);
            }
        });
    }
}
