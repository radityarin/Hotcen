package com.example.radit.hotcen;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alexzaitsev.meternumberpicker.MeterView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

public class AntrianPage extends AppCompatActivity {

    private Button bayar;
    private TextView noantriansaatini;
    private TextView nomorantrianpasien;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antrian_page);

        bayar = findViewById(R.id.bayar);
        bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AntrianPage.this,menuPembayaran.class);
                startActivity(intent);
            }
        });

        noantriansaatini = (TextView) findViewById(R.id.nomorantriansaatini);
        nomorantrianpasien = (TextView) findViewById(R.id.noantrian);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("NoAntrian");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String angka = dataSnapshot.getValue().toString();
                noantriansaatini.setText(angka);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());

            }
        });

        if(noantriansaatini.getText().equals(nomorantrianpasien.getText())){
            Intent intent =  new Intent (AntrianPage.this,menuPembayaran.class);
            startActivity(intent);
        }

    }
}
