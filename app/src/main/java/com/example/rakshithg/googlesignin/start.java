package com.example.rakshithg.googlesignin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class start extends AppCompatActivity {
    Button stubtn;
    Button compbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        stubtn =(Button)findViewById(R.id.sbt);
        compbtn=(Button)findViewById(R.id.cbt);


        stubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(start.this,MainActivity.class);
                startActivity(intent);
            }
        });

        compbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(start.this,company_register.class);
                startActivity(intent);
            }
        });

    }
}
