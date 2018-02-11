package myshoes.com.myshoes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

/**
 * Created by gopinath on 07/02/18.
 */

public class ProductView extends Fragment {

    ViewFlipper mViewFlipper;
    ImageView productImage;
    String imageUrl;
BottomNavigationView navigation;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       imageUrl = getArguments().getString("imageurl");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.product_view, container, false);
        //mViewFlipper = v.findViewById(R.id.product_images);
        productImage = v.findViewById(R.id.product_images);

        Glide.with(getActivity())
                .load(imageUrl)
                .into(productImage);
        return v;
    }

}
