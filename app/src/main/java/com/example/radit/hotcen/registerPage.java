package com.example.radit.hotcen;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class registerPage extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private FirebaseAuth Register;
    String tgllahir ="";

    TextView mytv;
    Typeface myfont;

    private Button register;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = Register.getCurrentUser();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        Register = FirebaseAuth.getInstance();


        mytv = findViewById(R.id.TextView);
        myfont = Typeface.createFromAsset(this.getAssets(),"fonts/MerriweatherSans-Regular.ttf");
        mytv.setTypeface(myfont);

        //tombol signup
        Button tombolRegis  =(Button) findViewById(R.id.regis);
        tombolRegis.setOnClickListener(this);

        Button btntgllhr = (Button) findViewById(R.id.buttontanggallahir);
        btntgllhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker ");
            }
        });

    }

    @Override
    public void onClick(View v) {
        final EditText Name = (EditText) findViewById(R.id.name);
        final EditText EmailRegis = (EditText) findViewById(R.id.emailregister);
        final EditText NoID = (EditText) findViewById(R.id.noID);
        EditText PasswordRegis = (EditText) findViewById(R.id.passwordregister);
        final EditText nohp = (EditText) findViewById(R.id.nohp);
        Register.createUserWithEmailAndPassword(EmailRegis.getText().toString(), PasswordRegis.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = Register.getCurrentUser();
                            Toast.makeText(registerPage.this, "Selamat datang di Hotcen", Toast.LENGTH_SHORT).show();
// Write a message to the database
                            FirebaseDatabase database = FirebaseDatabase.getInstance();
                            DatabaseReference myRef = database.getReference("Biodata").child(user.getUid());

                            Profil profil = new Profil(Name.getText().toString(), EmailRegis.getText().toString(), NoID.getText().toString(), nohp.getText().toString(), tgllahir );

                            myRef.setValue(profil);
                            Intent i = new Intent(registerPage.this, MainActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(registerPage.this, "errrr", Toast.LENGTH_SHORT).show();
                            // If sign in fails, display a message to the user.

                        }

                        // ...
                    }

                });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        tgllahir=currentDateString;
        Button button = (Button) findViewById(R.id.buttontanggallahir);
        button.setText(currentDateString);
    }
}