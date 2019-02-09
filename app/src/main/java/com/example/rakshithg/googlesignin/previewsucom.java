package com.example.rakshithg.googlesignin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class previewsucom extends AppCompatActivity {
    private DatabaseReference mDatabase;
    TextView textView;
    ImageView imageView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perviewsucom);
        textView = (TextView)findViewById(R.id.cnd);
        imageView=(ImageView)findViewById(R.id.imgc);



        String parent=  getIntent().getStringExtra("cname");
        Toast.makeText(previewsucom.this,parent,Toast.LENGTH_LONG).show();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("item").child(parent);
        mDatabase.keepSynced(true);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(previewsucom.this," let me see ",Toast.LENGTH_LONG).show();

                for(DataSnapshot ds: dataSnapshot.getChildren()) {
                    companyinfo cinfo = new companyinfo();
                    Toast.makeText(previewsucom.this," let me 234 ",Toast.LENGTH_LONG).show();




                    String dec = ds.child("desc").getValue(companyinfo.class).getCname();
                    textView.setText(dec);
                    ImageView imgiew = (ImageView) findViewById(R.id.imgc);
                    String imgr = ds.child("img2").getValue(companyinfo.class).getImg2();
                    Picasso.with(getApplicationContext()).load(imgr).into(imgiew);
                    Toast.makeText(previewsucom.this, " its " + dec + "  " + imgr, Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(previewsucom.this,"this is not a shit",Toast.LENGTH_LONG).show();

            }
        });




    }


}
