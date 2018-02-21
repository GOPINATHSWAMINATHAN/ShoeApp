package myshoes.com.myshoes.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import myshoes.com.myshoes.R;
import myshoes.com.myshoes.adapters.StoreAdapter;
import myshoes.com.myshoes.model.HomeShop;

/**
 * Created by gopinath on 06/02/18.
 */

public class Home extends Fragment {

    public static View.OnClickListener myOnClickListener;
    RecyclerView recyclerView;
    TextView name, price, discount;
    List<HomeShop> myShops;
    private StoreAdapter mAdapter;

    public Home() {

    }

    public static Home newInstance(String param1, String param2) {
        Home h = new Home();
        Bundle args = new Bundle();
        h.setArguments(args);
        return h;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myOnClickListener = new MyOnClickListener(getActivity());

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.home_fragment, container, false);
        recyclerView = v.findViewById(R.id.recycler_view);
        name = v.findViewById(R.id.title);
        price = v.findViewById(R.id.price);
        discount = v.findViewById(R.id.discount);
        myShops = new ArrayList<>();
        mAdapter = new StoreAdapter(getActivity(), myShops);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);


        fetchStoreItems();
        return v;
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private void fetchStoreItems() {


//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F2mfFLz12RhMUi6gYQt7w2Td04l43?alt=media&token=0e9653a1-07bf-4aad-b355-5ab83ca5f1a1", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2FbBF11AA6UDOIdyaHrhiPD1NJXbA2?alt=media&token=bb81ccc2-c5c6-4397-9667-b8c860f2c1ec", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F0knHaXSVVlgLTlqWoF7a5goZxLn2?alt=media&token=c64d56bd-ae8d-4232-a017-b756e1055397", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F0knHaXSVVlgLTlqWoF7a5goZxLn2?alt=media&token=c64d56bd-ae8d-4232-a017-b756e1055397", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F0knHaXSVVlgLTlqWoF7a5goZxLn2?alt=media&token=c64d56bd-ae8d-4232-a017-b756e1055397", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F0knHaXSVVlgLTlqWoF7a5goZxLn2?alt=media&token=c64d56bd-ae8d-4232-a017-b756e1055397", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F0knHaXSVVlgLTlqWoF7a5goZxLn2?alt=media&token=c64d56bd-ae8d-4232-a017-b756e1055397", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F0knHaXSVVlgLTlqWoF7a5goZxLn2?alt=media&token=c64d56bd-ae8d-4232-a017-b756e1055397", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F0knHaXSVVlgLTlqWoF7a5goZxLn2?alt=media&token=c64d56bd-ae8d-4232-a017-b756e1055397", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F0knHaXSVVlgLTlqWoF7a5goZxLn2?alt=media&token=c64d56bd-ae8d-4232-a017-b756e1055397", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F0knHaXSVVlgLTlqWoF7a5goZxLn2?alt=media&token=c64d56bd-ae8d-4232-a017-b756e1055397", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F0knHaXSVVlgLTlqWoF7a5goZxLn2?alt=media&token=c64d56bd-ae8d-4232-a017-b756e1055397", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F0knHaXSVVlgLTlqWoF7a5goZxLn2?alt=media&token=c64d56bd-ae8d-4232-a017-b756e1055397", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F0knHaXSVVlgLTlqWoF7a5goZxLn2?alt=media&token=c64d56bd-ae8d-4232-a017-b756e1055397", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F0knHaXSVVlgLTlqWoF7a5goZxLn2?alt=media&token=c64d56bd-ae8d-4232-a017-b756e1055397", "High Quality leather Shoe", "123", 23.3, 30));
//        myShops.add(new HomeShop("https://firebasestorage.googleapis.com/v0/b/hlacab-8eea3.appspot.com/o/profile_images%2F0knHaXSVVlgLTlqWoF7a5goZxLn2?alt=media&token=c64d56bd-ae8d-4232-a017-b756e1055397", "High Quality leather Shoe", "123", 23.3, 30));

    }

    private static class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            //removeItem(v);
        }
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
}
