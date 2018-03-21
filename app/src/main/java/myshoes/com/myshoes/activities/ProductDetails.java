package myshoes.com.myshoes.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import myshoes.com.myshoes.R;
import myshoes.com.myshoes.animations.BottomNavigationBehavior;
import myshoes.com.myshoes.database.CartDbHelper;
import myshoes.com.myshoes.model.Cart;

/**
 * Created by gopinath on 11/02/18.
 */

public class ProductDetails extends AppCompatActivity {
    String imageUrl1, thumbnail, imageURL2, prodName, description, price;
    ImageView productImage;
    TextView priceText, descriptionText, quantity;
    ImageButton increment, decrement;
    BottomNavigationView navigation;
    int productQuantities = 1;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.my_cart:
                            saveToDatabase();
                            return true;
                    }
                    return false;
                }
            };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_view);
        navigation = (BottomNavigationView) findViewById(R.id.purchase_navigation);
        increment = findViewById(R.id.cart_increment);
        decrement = findViewById(R.id.cart_decrement);
        quantity = findViewById(R.id.quantity);
        quantity.setText(String.valueOf(productQuantities));
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setItemIconTintList(null);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());
        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productQuantities++;
                quantity.setText(String.valueOf(productQuantities));
            }
        });
        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productQuantities <= 1) {

                    Toast.makeText(getApplicationContext(), "Minimum 1 quantity required", Toast.LENGTH_LONG).show();
                    productQuantities = 1;
                } else {
                    decrement.setEnabled(true);
                    productQuantities--;
                    quantity.setText(String.valueOf(productQuantities));
                }
            }
        });

        Bundle extras = getIntent().getExtras();
        imageUrl1 = extras.getString("image1");
        imageURL2 = extras.getString("image2");
        prodName = extras.getString("productname");
        description = extras.getString("description");
        price = extras.getString("price").toString();
        thumbnail = extras.getString("thumbnail");
        productImage = findViewById(R.id.product_images);
        priceText = findViewById(R.id.final_product_price);
        descriptionText = findViewById(R.id.description_text);
        priceText.setText(price + " SAR");
        descriptionText.setText(description);
        Glide.with(getApplicationContext())
                .load(thumbnail)
                .into(productImage);

//        Toast.makeText(getApplicationContext(),"myUrl is coming"+imageUrl,Toast.LENGTH_LONG).show();
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.product_view_menu, menu);
//        return true;
//    }
//x
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.my_cart:
//                Toast.makeText(this, "Adding to CartAdapter", Toast.LENGTH_LONG).show();
//                saveToDatabase();
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    private void saveToDatabase() {
        Cart c = new Cart();
        c.setProductName(prodName);
        c.setProductDescription(description);
        c.setProductPrice(price);
        c.setImageUrl(thumbnail);
        c.setProductQuantity(String.valueOf(productQuantities));
        boolean a = new CartDbHelper(getApplicationContext()).insertProducts(c);
        if (a) {
            Toast.makeText(getApplicationContext(), "Added to CartAdapter", Toast.LENGTH_LONG).show();
        }
    }


}
