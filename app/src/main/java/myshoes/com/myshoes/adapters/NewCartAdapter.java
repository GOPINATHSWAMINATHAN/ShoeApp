package myshoes.com.myshoes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import myshoes.com.myshoes.R;
import myshoes.com.myshoes.database.CartDbHelper;
import myshoes.com.myshoes.model.Cart;

/**
 * Created by gopinath on 21/03/18.
 */

public class NewCartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 2;
    private int productQuantities = 1;
    private ArrayList<Cart> cartList;
    private Context context;
    private StoreAdapter.ListItemClickListener mOnClickListener;

    public NewCartAdapter(Context context, ArrayList<Cart> cartList, StoreAdapter.ListItemClickListener mOnClickListener) {
        this.context = context;
        this.cartList = cartList;
        this.mOnClickListener = mOnClickListener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            //Inflating recycle view item layout
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_fragment, parent, false);
            return new ItemViewHolder(itemView);
        } else if (viewType == TYPE_HEADER) {
            //Inflating header view
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_header, parent, false);
            return new HeaderViewHolder(itemView);
        } else if (viewType == TYPE_FOOTER) {
            //Inflating footer view
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_footer, parent, false);
            return new FooterViewHolder(itemView);
        } else return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
        } else if (holder instanceof FooterViewHolder) {
            FooterViewHolder footerHolder = (FooterViewHolder) holder;
        } else if (holder instanceof ItemViewHolder) {
            final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.productName.setText(cartList.get(position).getProductName());
            itemViewHolder.description.setText(cartList.get(position).getProductDescription());
            itemViewHolder.price.setText(cartList.get(position).getProductPrice());
            itemViewHolder.quantity.setText(cartList.get(position).getProductQuantity());
            Glide.with(context).load(cartList.get(position).getImageUrl()).into(itemViewHolder.thumbnail);
            itemViewHolder.increment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    productQuantities++;
                    boolean isSuccessfull = new CartDbHelper(context).updateQuantity(productQuantities, position);
                    itemViewHolder.quantity.setText(String.valueOf(productQuantities));
                    Log.e("UPDATE TABLE", "updated successfully" + isSuccessfull);
                }
            });
            itemViewHolder.decrement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (productQuantities <= 1) {

                        Toast.makeText(context, "Minimum 1 quantity required", Toast.LENGTH_LONG).show();
                        productQuantities = 1;
                        new CartDbHelper(context).updateQuantity(productQuantities, position);

                    } else {
                        itemViewHolder.decrement.setEnabled(true);
                        productQuantities--;
                        new CartDbHelper(context).updateQuantity(productQuantities, position);
                        itemViewHolder.quantity.setText(String.valueOf(productQuantities));

                    }
                }
            });
            itemViewHolder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isSuccessful = new CartDbHelper(context).deleteCartProduct(cartList.get(position).getProductId());
                    if (isSuccessful) {
                        removeAt(itemViewHolder.getAdapterPosition());
                        Log.e("DELETE QUERY", "SUCCESSFULLY DELETED");
                    } else {
                        Log.e("DELETE QUERY", "NOT SUCCESSFULL" + isSuccessful);
                    }
                }
            });
        }
    }

    private void removeAt(int position) {
        cartList.remove(position);
        notifyItemRemoved(position);
        notifyItemChanged(position, cartList.size());
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position == cartList.size() + 1) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return cartList.size() + 2;
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        // TextView headerTitle;

        public HeaderViewHolder(View view) {
            super(view);
            // headerTitle = (TextView) view.findViewById(R.id.header_text);
        }
    }

    private class FooterViewHolder extends RecyclerView.ViewHolder {
        //TextView footerText;

        public FooterViewHolder(View view) {
            super(view);
            //footerText = (TextView) view.findViewById(R.id.footer_text);
        }
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView productName, description, price, quantity;
        private ImageView thumbnail, delete;
        private ImageButton increment, decrement;

        public ItemViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            productName = itemView.findViewById(R.id.cart_product_name);
            description = itemView.findViewById(R.id.cart_brand_name);
            increment = itemView.findViewById(R.id.cart_increment);
            decrement = itemView.findViewById(R.id.cart_decrement);
            price = itemView.findViewById(R.id.cart_product_price);
            quantity = itemView.findViewById(R.id.cart_quantity);
            delete = itemView.findViewById(R.id.cart_delete);
            thumbnail = itemView.findViewById(R.id.cart_product_image);
        }
    }
}
