package myshoes.com.myshoes.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import myshoes.com.myshoes.R;
import myshoes.com.myshoes.activities.ProductDetails;
import myshoes.com.myshoes.model.HomeData;

/**
 * Created by gopinath on 06/02/18.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder> {
    ListItemClickListener mOnClickListener;
    private Context context;
    private List<HomeData> movieList = new ArrayList<>();


    public StoreAdapter(Context context, List<HomeData> movieList) {
        this.context = context;
        this.movieList = movieList;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_home, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item clicked is true", Toast.LENGTH_LONG).show();
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final HomeData movie = movieList.get(position);

        holder.name.setText(movie.getDescription().get(position).toString());
        holder.price.setText(movie.getMrpPrice().get(position).toString());
        Glide.with(context)
                .load(movie.getThumbnail().get(position))
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        holder.myRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pIntent = new Intent(context, ProductDetails.class);
                Bundle pBundle = new Bundle();
                pBundle.putString("imageurl", movieList.get(position).getImage().toString());
                pIntent.putExtras(pBundle);
                context.startActivity(pIntent);
                Toast.makeText(context, "Position is " + movieList.get(position).getImage(), Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        Log.e("MOVIELIST size", "" + movieList.size());
        return movieList.size();

    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, price, discount;
        public ImageView thumbnail;
        public CardView myCardView;
        LinearLayout myLinearLayout;
        RelativeLayout myRelative;

        public MyViewHolder(View view) {
            super(view);

            context = view.getContext();
            name = view.findViewById(R.id.title);
            price = view.findViewById(R.id.price);
            thumbnail = view.findViewById(R.id.thumbnail);
            myCardView = view.findViewById(R.id.card_view);
            myLinearLayout = view.findViewById(R.id.myLinearLayout);
            myRelative = view.findViewById(R.id.myRelative);
            discount = view.findViewById(R.id.discount);
            view.setOnClickListener(this);
            Typeface font = Typeface.createFromAsset(context.getAssets(), "Nunito-Regular.ttf");
            name.setTypeface(font);
            price.setTypeface(font);
            discount.setTypeface(font);
        }


        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
