package com.example.rakshithg.googlesignin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class loginpage extends AppCompatActivity {
    Button login,signupn,forgotpass,signini;
    public String username,pass;
    EditText usernamee,passwo;
    FirebaseDatabase database;
    DatabaseReference users;
    private DatabaseReference mReference;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        login =(Button)findViewById(R.id.btnLogin);
        signupn =(Button)findViewById(R.id.signupin);
        usernamee=(EditText)findViewById(R.id.user);
        passwo=(EditText)findViewById(R.id.password);
        forgotpass=(Button)findViewById(R.id.forgot);
        users = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username= usernamee.getText().toString().trim();
                pass= passwo.getText().toString().trim();

                if(TextUtils.isEmpty(username)){
                    Toast.makeText(loginpage.this,"U can't leave Email id Empty",Toast.LENGTH_LONG).show();
                    return;

                }
                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(loginpage.this,"Is this Your Password Really?",Toast.LENGTH_LONG).show();
                    return;

                }
                else {
                    Singn();

                }
            }
        });

        signupn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginpage.this,registersu.class);
                startActivity(intent);
            }
        });

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= usernamee.getText().toString().trim();
                Toast.makeText(loginpage.this,email,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(loginpage.this,forgotpass.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });
//

    }

    private void Singn() {
        mAuth.signInWithEmailAndPassword(username, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithEmail:success");
                            Toast.makeText(loginpage.this,"scusessfully loaded",Toast.LENGTH_LONG).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                           // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithEmail:failure", task.getException());
                            Toast.makeText(loginpage.this, "Try to remember your password clearly or just say forgot password",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });



    }
    @Override
    public void onStart() {
        super.onStart();
//         Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }





}
