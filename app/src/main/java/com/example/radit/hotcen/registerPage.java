package com.example.radit.hotcen;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class registerPage extends AppCompatActivity {

    TextView mytv;
    Typeface myfont;

    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        mytv = findViewById(R.id.TextView);
        myfont = Typeface.createFromAsset(this.getAssets(),"fonts/MerriweatherSans-Regular.ttf");
        mytv.setTypeface(myfont);

        //tombol signup
        register =findViewById(R.id.regis);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registerPage.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
