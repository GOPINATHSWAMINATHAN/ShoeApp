package myshoes.com.myshoes.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import myshoes.com.myshoes.R;

/**
 * Created by gopinath on 12/02/18.
 */

public class Kids extends Fragment {

    TextView textOne, textTwo, textThree, textFour, textFive, TextSix;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        //Inflated kids category with this fragment
        View v = inflater.inflate(R.layout.kids_category, container, false);
        return v;
    }
}
