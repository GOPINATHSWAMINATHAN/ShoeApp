package myshoes.com.myshoes.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
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

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {
    private ListItemClickListener mOnClickListener;
    private Context context;
    private List<HomeData> shoesList = new ArrayList<>();


    public StoreAdapter(Context context, List<HomeData> movieList, ListItemClickListener listener) {
        this.context = context;
        this.shoesList = movieList;
        this.mOnClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.store_home, parent, false);
        ViewHolder myViewHolder = new ViewHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item clicked is true", Toast.LENGTH_LONG).show();
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.name.setText(shoesList.get(position).getProdName());
        holder.price.setText(String.valueOf(shoesList.get(position).getMrpPrice()));
        holder.discount.setText(String.valueOf(shoesList.get(position).getDiscountPrice()));
        Glide.with(context)
                .load(shoesList.get(position).getThumbnail())
                .into(holder.thumbnail);

//        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
        holder.myRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pIntent = new Intent(context, ProductDetails.class);
                Bundle pBundle = new Bundle();
                pBundle.putString("imageurl", shoesList.get(position).getImages().get(0).toString());
                pBundle.putString("imageurl1", shoesList.get(position).getImages().get(1).toString());
                pIntent.putExtras(pBundle);
                context.startActivity(pIntent);
                Toast.makeText(context, "Position is " + shoesList.get(position).getImages(), Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        Log.e("MOVIELIST size", "" + shoesList.size());
        return shoesList.size();

    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout myLinearLayout;
        RelativeLayout myRelative;
        private TextView name, price, discount, currencyType;
        private ImageView thumbnail;
        private CardView myCardView;

        public ViewHolder(View view) {
            super(view);
            context = view.getContext();
            name = view.findViewById(R.id.title);
            price = view.findViewById(R.id.price);
            thumbnail = view.findViewById(R.id.thumbnail);
            myCardView = view.findViewById(R.id.card_view);
            myLinearLayout = view.findViewById(R.id.myLinearLayout);
            currencyType = view.findViewById(R.id.currency_type);
            myRelative = view.findViewById(R.id.myRelative);
            discount = view.findViewById(R.id.discount);
            price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            view.setOnClickListener(this);
            Typeface font = Typeface.createFromAsset(context.getAssets(), "Nunito-Regular.ttf");
            name.setTypeface(font);
            price.setTypeface(font);
            discount.setTypeface(font);
            currencyType.setTypeface(font);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            Toast.makeText(context, "Item clicked is true", Toast.LENGTH_LONG).show();
        }
    }
}