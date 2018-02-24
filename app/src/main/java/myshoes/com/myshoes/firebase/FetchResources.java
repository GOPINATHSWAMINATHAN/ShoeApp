package myshoes.com.myshoes.firebase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import myshoes.com.myshoes.model.HomeData;

/**
 * Created by gopinath on 21/02/18.
 */

public class FetchResources extends AppCompatActivity {
    ArrayList<HomeData> mHomeData;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHomeData = new ArrayList();
    }


}
