package myshoes.com.myshoes.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myshoes.com.myshoes.R;

/**
 * Created by gopinath on 06/02/18.
 */

public class Profile extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        //Inflated kids category with this fragment
        View v = inflater.inflate(R.layout.profile_fragment, container, false);
        return v;
    }
}
