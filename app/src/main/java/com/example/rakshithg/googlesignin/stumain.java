package com.example.rakshithg.googlesignin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class stumain extends AppCompatActivity {
    private RecyclerView mBlogList;
    private DatabaseReference mDatabase, mrefer;
    //    @BindView(R.id.star_button)
//    LikeButton starButton;
//    @BindView(R.id.thumb_button)
//    LikeButton thumbButton;
    String nr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stumain);
//        ButterKnife.bind(this);
//        starButton.setOnAnimationEndListener(this);
//        starButton.setOnLikeListener(this);
//
//        thumbButton.setOnLikeListener(this);
//        thumbButton.setOnAnimationEndListener(this);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("item");
        mDatabase.keepSynced(true);

        mBlogList = (RecyclerView) findViewById(R.id.recycle);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new LinearLayoutManager(this));


    }

    public void onclickcard(View view) {

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void liked(LikeButton likeButton) {
//        Toast.makeText(this, "Liked!", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void unLiked(LikeButton likeButton) {
//        Toast.makeText(this, "Disliked!", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override public void onAnimationEnd(LikeButton likeButton) {
//        Log.d("TAG", "Animation End for %s" + likeButton);
//    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Blog, BlogView> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Blog, BlogView>
                (Blog.class, R.layout.cardview, BlogView.class, mDatabase) {
            @Override
            protected void populateViewHolder(BlogView viewHolder, Blog model, int position) {
                viewHolder.setcname(model.getCname());
                viewHolder.setaddress(model.getAddress());
                viewHolder.setsal(model.getSal());
                viewHolder.setimg(getApplicationContext(), model.getImage());


            }

            @Override
            public BlogView onCreateViewHolder(ViewGroup parent, int viewType) {
                BlogView viewHolder = super.onCreateViewHolder(parent , viewType);
                viewHolder.setOnclickListener(new BlogView.clickListener() {
                    @Override
                    public void onitemclick(View view, int postion) {
                        TextView comna= view.findViewById(R.id.cname);
                         final String cnames= comna.getText().toString();


                        DatabaseReference reference;
                        reference = FirebaseDatabase.getInstance().getReference().child("item");
                        reference.orderByChild("cname").equalTo(cnames).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                                    String parent = childSnapshot.getKey();
                                    Toast.makeText(stumain.this, "" + parent+cnames, Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(stumain.this,previewsucom.class);
                                    intent.putExtra("cname",parent);
                                    startActivity(intent);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {


                                Toast.makeText(stumain.this, "its not working", Toast.LENGTH_LONG).show();
                            }
                        });

                    }

                    @Override
                    public void onitemlongclick(View view, int postion) {




                    }
                });

                return viewHolder;
            }
        };
        mBlogList.setAdapter(firebaseRecyclerAdapter);

    }
}
