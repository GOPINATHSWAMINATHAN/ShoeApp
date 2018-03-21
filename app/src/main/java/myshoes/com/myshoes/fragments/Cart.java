package myshoes.com.myshoes.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import myshoes.com.myshoes.R;
import myshoes.com.myshoes.adapters.CartAdapter;
import myshoes.com.myshoes.adapters.StoreAdapter;
import myshoes.com.myshoes.database.CartDbHelper;

/**
 * Created by gopinath on 06/02/18.
 */

public class Cart extends Fragment implements StoreAdapter.ListItemClickListener {

    RecyclerView recyclerView;
    CartAdapter cAdapter;
    ArrayList<myshoes.com.myshoes.model.Cart> mCartProducts;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.category_recycler, container, false);
        recyclerView = v.findViewById(R.id.category_recycler_view);
        mCartProducts = new ArrayList<myshoes.com.myshoes.model.Cart>();
        mCartProducts = (ArrayList<myshoes.com.myshoes.model.Cart>) retrieveFromDatabase();
        cAdapter = new CartAdapter(getActivity(), mCartProducts, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(cAdapter);
        return v;
    }

    private List<myshoes.com.myshoes.model.Cart> retrieveFromDatabase() {
        List<myshoes.com.myshoes.model.Cart> retrievedData = new CartDbHelper(getActivity()).getData();

//            Log.e("RETRIEVED DATASQLITE", "/" + retrievedData.get(0).getProductId());

        //new CartDbHelper(getActivity()).deleteEntireCart();

        return retrievedData;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }
}
