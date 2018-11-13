package com.example.radit.hotcen;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class signinPage extends AppCompatActivity {

    TextView mytv;
    Typeface myfont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_page);

        mytv = findViewById(R.id.TextView);
        myfont = Typeface.createFromAsset(this.getAssets(),"fonts/MerriweatherSans-Regular.ttf");
        mytv.setTypeface(myfont);
    }
}
