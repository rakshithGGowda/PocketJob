package com.example.rakshithg.googlesignin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

class BlogView extends RecyclerView.ViewHolder
{
    View mView;

    public BlogView(@NonNull View itemView) {
        super(itemView);
        mView=itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mclickListener.onitemclick(view,getAdapterPosition());
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mclickListener.onitemlongclick(view,getAdapterPosition());
                return true;
            }
        });
    }
    public void setcname(String cname)
    {
        TextView cview = (TextView)mView.findViewById(R.id.cname);
        cview.setText(cname);
    }
    public void setaddress(String address) {
        TextView addview = (TextView)mView.findViewById(R.id.address);
        addview.setText(address);

    }
    public void setsal(String sal) {
        TextView salview = (TextView)mView.findViewById(R.id.salary);
        salview.setText(sal);

    }
    public void setimg(Context ctx, String image) {
        ImageView imgiew = (ImageView)mView.findViewById(R.id.img);
        Picasso.with(ctx).load(image).into(imgiew);
    }

    private BlogView.clickListener mclickListener;


    public interface clickListener{
        void onitemclick(View view,int postion);
        void onitemlongclick(View view , int postion);

    }
    public void setOnclickListener(BlogView.clickListener clickListener){
        mclickListener=clickListener;
    }

}