package myshoes.com.myshoes.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import myshoes.com.myshoes.R;
import myshoes.com.myshoes.animations.BottomNavigationBehavior;

/**
 * Created by gopinath on 11/02/18.
 */

public class ProductDetails extends AppCompatActivity {
    String imageUrl, imageURL2;
    ImageView productImage;
    BottomNavigationView navigation;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_view);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);

        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setItemIconTintList(null);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());
        Bundle extras = getIntent().getExtras();
        imageUrl = extras.getString("imageurl");
        imageURL2 = extras.getString("imageurl2");
        productImage = findViewById(R.id.product_images);

        Glide.with(getApplicationContext())
                .load(imageUrl)
                .into(productImage);

//        Toast.makeText(getApplicationContext(),"myUrl is coming"+imageUrl,Toast.LENGTH_LONG).show();
    }
}
