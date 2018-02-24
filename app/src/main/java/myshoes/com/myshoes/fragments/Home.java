package myshoes.com.myshoes.fragments;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import myshoes.com.myshoes.R;
import myshoes.com.myshoes.adapters.StoreAdapter;
import myshoes.com.myshoes.model.HomeData;
import myshoes.com.myshoes.model.HomeShop;

/**
 * Created by gopinath on 06/02/18.
 */

public class Home extends Fragment implements StoreAdapter.ListItemClickListener {

    RecyclerView recyclerView;
    TextView name, price, discount;
    ArrayList<HomeShop> myShops;
    ArrayList<HomeData> mHomeData;
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
        mHomeData = new ArrayList<>();


        new getdata().execute();

        mAdapter = new StoreAdapter(getActivity(), mHomeData, this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);

        return v;
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Log.e("MY CLICK IS ", "" + clickedItemIndex);
        Toast.makeText(getActivity(), "clickedon" + clickedItemIndex, Toast.LENGTH_LONG).show();
    }

    void fetchResults(DataSnapshot dataSnapshot) {
        long count = dataSnapshot.getChildrenCount();
        Log.d("Child Count ", String.valueOf(count));
        for (DataSnapshot ds : dataSnapshot.getChildren()) {

            String color = ds.child("color").getValue(String.class);
            String desc = ds.child("description").getValue(String.class);
            String discPrice = ds.child("discountPrice").getValue(String.class);
            String material = ds.child("material").getValue(String.class);
            String modelName = ds.child("modelName").getValue(String.class);
            String mrpPrice = ds.child("mrpPrice").getValue(String.class);
            String occasion = ds.child("occasion").getValue(String.class);
            String prodName = ds.child("prodName").getValue(String.class);
            String sizes = ds.child("sizeAvailable").getValue(String.class);
            String rating = ds.child("rating").child("star").getValue(String.class);
            String thumb = ds.child("thumbnail").getValue(String.class);
            ArrayList<String> imageList = new ArrayList<>();

            DataSnapshot images = ds.child("image");
            Log.d("Images Size", String.valueOf(images.getChildrenCount()));
            for (int i = 0; i < images.getChildrenCount(); i++) {
                String img1 = images.child("image1").getValue(String.class);
                String img2 = images.child("image2").getValue(String.class);
                imageList.add(img1);
                imageList.add(img2);

                Log.d("Images", img1 + "  " + img2);
            }
            Log.d("Data", color + "/" + desc + "/"
                    + discPrice + "/" + material + "/" + modelName + "/" + mrpPrice + "/" + occasion
                    + "/" + prodName + "/" + sizes + "/" + rating);

            mHomeData.add(new HomeData(
                    color,
                    desc,
                    modelName,
                    material,
                    occasion,
                    prodName,
                    Integer.parseInt(discPrice),
                    Integer.parseInt(mrpPrice),
                    sizes,
                    Integer.parseInt(rating),
                    thumb,
                    imageList
            ));


        }
    }

    class getdata extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getInstance().getReference().child("home");
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    fetchResults(dataSnapshot);
                    mAdapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
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