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
import java.util.List;

import myshoes.com.myshoes.R;
import myshoes.com.myshoes.database.CartDbHelper;
import myshoes.com.myshoes.model.Cart;

/**
 * Created by gopinath on 20/03/18.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    int productQuantities = 1;
    private StoreAdapter.ListItemClickListener mOnClickListener;
    private Context context;
    private List<Cart> cartList = new ArrayList<>();

    public CartAdapter(Context context, List<Cart> cartProducts, StoreAdapter.ListItemClickListener listener) {
        this.context = context;
        this.cartList = cartProducts;
        this.mOnClickListener = listener;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_fragment, parent, false);
        final CartViewHolder myViewHolder = new CartViewHolder(itemView);

        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(final CartViewHolder holder, final int position) {
        holder.productName.setText(cartList.get(position).getProductName());
        holder.description.setText(cartList.get(position).getProductDescription());
        holder.price.setText(cartList.get(position).getProductPrice());
        holder.quantity.setText(cartList.get(position).getProductQuantity());
        Glide.with(context).load(cartList.get(position).getImageUrl()).into(holder.thumbnail);
        holder.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productQuantities++;
                boolean isSuccessfull = new CartDbHelper(context).updateQuantity(productQuantities, position);
                holder.quantity.setText(String.valueOf(productQuantities));
                Log.e("UPDATE TABLE", "updated successfully" + isSuccessfull);
            }
        });
        holder.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productQuantities <= 1) {

                    Toast.makeText(context, "Minimum 1 quantity required", Toast.LENGTH_LONG).show();
                    productQuantities = 1;
                    new CartDbHelper(context).updateQuantity(productQuantities, position);
                } else {
                    holder.decrement.setEnabled(true);
                    productQuantities--;
                    new CartDbHelper(context).updateQuantity(productQuantities, position);
                    holder.quantity.setText(String.valueOf(productQuantities));
                }
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSuccessful = new CartDbHelper(context).deleteCartProduct(cartList.get(position).getProductId());
                if (isSuccessful) {
                    removeAt(holder.getAdapterPosition());
                    Log.e("DELETE QUERY", "SUCCESSFULLY DELETED");
                } else {
                    Log.e("DELETE QUERY", "NOT SUCCESSFULL" + isSuccessful);
                }
            }
        });
    }

    public void removeAt(int position) {
        cartList.remove(position);
        notifyItemRemoved(position);
        notifyItemChanged(position, cartList.size());
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        private TextView productName, description, price, quantity;
        private ImageView thumbnail, delete;
        private ImageButton increment, decrement;


        CartViewHolder(View itemView) {
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
