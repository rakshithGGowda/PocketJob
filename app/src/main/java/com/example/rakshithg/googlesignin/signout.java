package com.example.rakshithg.googlesignin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class signout extends AppCompatActivity {
    private Button signout;
    private FirebaseAuth mAuth;
    private TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signout);
        t1=(TextView)findViewById(R.id.te1);
        t2=(TextView)findViewById(R.id.te2);

        signout= (Button)findViewById(R.id.sign_out);
        t1.setText("Your Name is:"+getIntent().getStringExtra("name"));
        t2.setText("Your id is:"+getIntent().getStringExtra("id"));


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mAuth.signOut();


                startActivity(new Intent(com.example.rakshithg.googlesignin.signout.this,MainActivity.class));
            }
        });
    }
}
