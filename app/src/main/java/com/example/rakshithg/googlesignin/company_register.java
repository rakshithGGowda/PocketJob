package com.example.rakshithg.googlesignin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class company_register extends AppCompatActivity {

     private Button btn,compsign;
     EditText cname,emai,adress,phon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_register);

        btn = (Button)findViewById(R.id.upload) ;
        cname = (EditText)findViewById(R.id.companyname) ;
        emai = (EditText)findViewById(R.id.email) ;
        adress = (EditText)findViewById(R.id.address) ;
        phon = (EditText)findViewById(R.id.phonenumber) ;
        compsign = (Button)findViewById(R.id.cosign);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ocname,email,phone,adresss;
                email = emai.getText().toString().trim();
                ocname = cname.getText().toString().trim();
                adresss = adress.getText().toString().trim();
                phone = phon.getText().toString().trim();
                Intent intent = new Intent(company_register.this,uploadcinfo.class);
                intent.putExtra("cname",ocname);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                intent.putExtra("address",adresss);

                startActivity(intent);
            }
        });
        compsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(company_register.this,comp_login.class);
                startActivity(intent);
            }
        });


    }
}
