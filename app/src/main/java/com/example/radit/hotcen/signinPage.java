package com.example.radit.hotcen;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signinPage extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth logIn;
    private Button regis;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = logIn.getCurrentUser();
        if (currentUser != null) {
            Intent i = new Intent(signinPage.this, MainActivity.class);
            startActivity(i);
        }
    }

    TextView mytv;
    Typeface myfont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_page);
        logIn = FirebaseAuth.getInstance();

        Button tombolLogin = (Button) findViewById(R.id.login);

        tombolLogin.setOnClickListener(this);

        regis = findViewById(R.id.regis);
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signinPage.this,registerPage.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        EditText Email = (EditText) findViewById(R.id.emaillogin);
        EditText Password = (EditText) findViewById(R.id.passwordlogin);

        logIn.signInWithEmailAndPassword(Email.getText().toString(), Password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = logIn.getCurrentUser();
                            Toast.makeText(signinPage.this, "BERHASIL", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(signinPage.this, MainActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(signinPage.this, "GAGAL", Toast.LENGTH_SHORT).show();
                        }
                        // ...
                    }
                });
    }
}
