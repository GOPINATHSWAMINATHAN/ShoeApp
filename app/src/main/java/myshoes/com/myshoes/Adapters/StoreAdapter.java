package myshoes.com.myshoes.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import myshoes.com.myshoes.R;
import myshoes.com.myshoes.model.HomeShop;
import myshoes.com.myshoes.ProductActivityDemo;

/**
 * Created by gopinath on 06/02/18.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
    private Context context;
    private List<HomeShop> movieList;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price,discount;
        public ImageView thumbnail;
        public CardView myCardView;
        LinearLayout myLinearLayout;
        RelativeLayout myRelative;

        public MyViewHolder(View view) {
            super(view);

            context=view.getContext();
            name = view.findViewById(R.id.title);
            price = view.findViewById(R.id.price);
            thumbnail = view.findViewById(R.id.thumbnail);
            myCardView=view.findViewById(R.id.card_view);
            myLinearLayout=view.findViewById(R.id.myLinearLayout);
            myRelative=view.findViewById(R.id.myRelative);
            discount=view.findViewById(R.id.discount);

            Typeface font = Typeface.createFromAsset(context.getAssets(), "Nunito-Regular.ttf");
            name.setTypeface(font);
            price.setTypeface(font);
            discount.setTypeface(font);
        }


    }


    public StoreAdapter(Context context, List<HomeShop> movieList) {
        this.context = context;
        this.movieList = movieList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_home, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Item clicked is true",Toast.LENGTH_LONG).show();
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final HomeShop movie = movieList.get(position);

        holder.name.setText(movie.getProductName());
        holder.price.setText(Double.toString(movie.getProductPrice()));
        Glide.with(context)
                .load(movie.getImageUrl())
                .into(holder.thumbnail);
holder.thumbnail.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//        FragmentTransaction ft=((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.frame_container,new ProductView());
//        ft.addToBackStack(null);
//        ft.commit();
    }
});
        holder.myRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                FragmentTransaction ft=((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
//                Bundle bundle=new Bundle();
//                bundle.putString("imageurl",movieList.get(position).getImageUrl());
//                ProductView pv=new ProductView();
//                pv.setArguments(bundle);
//                ft.replace(R.id.frame_container,pv);
//                ft.addToBackStack(null);
//                ft.commit();

                Intent pIntent = new Intent(context, ProductActivityDemo.class);
                Bundle pBundle = new Bundle();
                pBundle.putString("imageurl", movieList.get(position).getImageUrl());
                pIntent.putExtras(pBundle);
                context.startActivity(pIntent);

//context.startActivity(new Intent(context, ProductActivityDemo.class));
//                FragmentTransaction transaction=((FragmentActivity(context)).getSupportFragmentManager().beginTransaction());
//                transaction.replace(R.id.frame_container,fragment);
//                transaction.addToBackStack(null);
//                transaction.commit();
                Toast.makeText(context,"Position is "+movieList.get(position).getImageUrl(),Toast.LENGTH_LONG).show();
            }
        });


    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
