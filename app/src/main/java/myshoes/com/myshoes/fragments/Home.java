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
import java.util.List;

import myshoes.com.myshoes.R;
import myshoes.com.myshoes.adapters.StoreAdapter;
import myshoes.com.myshoes.model.HomeData;
import myshoes.com.myshoes.model.HomeShop;

/**
 * Created by gopinath on 06/02/18.
 */

public class Home extends Fragment implements StoreAdapter.ListItemClickListener {

    public static View.OnClickListener myOnClickListener;
    RecyclerView recyclerView;
    TextView name, price, discount;
    List<HomeData> al = new ArrayList<>();
    List<HomeShop> myShops;
    List<HomeData> mHomeData;
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

        new FetchHomeData().execute();
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

    class FetchHomeData extends AsyncTask<Void, Void, List<HomeData>> {

        @Override
        protected List<HomeData> doInBackground(Void... voids) {
            String color;
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("home");
            ref.addListenerForSingleValueEvent(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            ArrayList<String> description = new ArrayList<>(),
                                    discountPrice = new ArrayList<>(),
                                    material = new ArrayList<>(), modelName = new ArrayList<>(),
                                    mrpPrice = new ArrayList<>(), occassion = new ArrayList<>(), prodName = new ArrayList<>(),
                                    sizeAvailable = new ArrayList<>(), star = new ArrayList<>(), imageUrl = new ArrayList<>(), thumbnail = new ArrayList<>();
                            ArrayList<String> color = new ArrayList();
//                        String color=dataSnapshot.child("color").getValue().toString();
//
////                        Iterable<DataSnapshot> homeData = dataSnapshot.getChildren();
////                        //Get map of users in datasnapshot
////
////                        for (DataSnapshot ds : homeData) {
////
////                          String color=  ds.child("color").toString();
////                          String description=ds.child("description").toString();
////                           mHomeData.add(color);
////                           mHomeData.add(description);
////                        }
                            ArrayList<String> imagesUrl = new ArrayList<>();

                            int flag = 0;
                            for (DataSnapshot homeData : dataSnapshot.getChildren()) {
                                String mycolor = homeData.child("color").getValue().toString();
                                color.add(mycolor);
                                String mdescription = homeData.child("description").getValue().toString();
                                description.add(mdescription);
                                String mdiscountPrice = homeData.child("discountPrice").getValue().toString();
                                discountPrice.add(mdiscountPrice);
                                String mmaterial = homeData.child("material").getValue().toString();
                                material.add(mmaterial);
                                String mmodelName = homeData.child("modelName").getValue().toString();
                                modelName.add(mmodelName);
                                String mmrpPrice = homeData.child("mrpPrice").getValue().toString();
                                mrpPrice.add(mmrpPrice);
                                String moccassion = homeData.child("occasion").getValue().toString();
                                occassion.add(moccassion);
                                String mprodName = homeData.child("prodName").getValue().toString();
                                prodName.add(mprodName);
                                String mstar = homeData.child("rating").child("star").getValue().toString();
                                star.add(mstar);
                                String msizeAvailable = homeData.child("sizeAvailable").getValue().toString();
                                sizeAvailable.add(msizeAvailable);
                                String mthumbnail = homeData.child("thumbnail").getValue().toString();
                                thumbnail.add(mthumbnail);
                                if (flag == 0) {
                                    for (DataSnapshot images : dataSnapshot.getChildren()) {
                                        flag = 1;

                                        for (int i = 1; i <= images.child("image").getChildrenCount(); i++) {

                                            Log.e("Images", "" + images.child("image").child("image" + i).toString());
                                            String mimageUrl = images.child("image").child("image" + i).getValue().toString();
                                            imagesUrl.add(mimageUrl);

                                        }


                                    }

                                }
                                Log.e("COLOR VALUE IS ", "" + color);

                                mHomeData.add(new HomeData(color, description, modelName, material, occassion, prodName, discountPrice, mrpPrice, sizeAvailable, imagesUrl, thumbnail));
//                            ListIterator<HomeData> itr = mHomeData.listIterator();
//                            while (itr.hasNext()) {
//                                Log.e("MY VALUES AREEEE", "" + itr.next().getColor());
//                            }

                            }


                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            //handle databaseError
                        }
                    });

            return mHomeData;
        }

        @Override
        protected void onPostExecute(List<HomeData> homeData) {
            mAdapter = new StoreAdapter(getActivity(), homeData);
            super.onPostExecute(homeData);
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
