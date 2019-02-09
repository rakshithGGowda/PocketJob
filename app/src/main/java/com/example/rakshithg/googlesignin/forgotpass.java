package com.example.rakshithg.googlesignin;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpass extends AppCompatActivity {
    Button sendreq;
    EditText email;
    TextView t;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);
        mAuth = FirebaseAuth.getInstance();
        sendreq = (Button) findViewById(R.id.sentreq);
        email = (EditText) findViewById(R.id.emailu);
        t = (TextView)findViewById(R.id.textView3);
        String e = getIntent().getStringExtra("email");
        email.setText(e);

        sendreq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(email.getText().toString().trim())) {
                    Toast.makeText(forgotpass.this, "The the email id is empty.Please enter the valid email", Toast.LENGTH_LONG).show();


                } else {
                    resetpass();

                }

            }


        });
    }


    private void resetpass() {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = email.getText().toString().trim();

        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(forgotpass.this,"Message is sent to your email account ",Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }


}
