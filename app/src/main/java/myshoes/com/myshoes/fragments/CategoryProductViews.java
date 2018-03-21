package myshoes.com.myshoes.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import myshoes.com.myshoes.R;
import myshoes.com.myshoes.adapters.CategoryProductsAdapter;
import myshoes.com.myshoes.model.CategoryProducts;

/**
 * Created by gopinath on 18/03/18.
 */

public class CategoryProductViews extends Fragment implements CategoryProductsAdapter.ListItemClickListener {
    RecyclerView recyclerView;
    CategoryProductsAdapter mAdapter;
    ArrayList<CategoryProducts> mCategoryData;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.category_recycler, container, false);
        recyclerView = v.findViewById(R.id.category_recycler_view);
        mCategoryData = new ArrayList<>();
        new GetData().execute();
        mAdapter = new CategoryProductsAdapter(getActivity(), mCategoryData, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
        return v;

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
            //String rating = ds.child("rating").child("star").getValue(String.class);
            String thumb = ds.child("thumbnail").getValue(String.class);
            ArrayList<String> imageList = new ArrayList<>();
            DataSnapshot images = ds.child("image");
            Log.d("Images Size", String.valueOf(images.getChildrenCount()));
            for (int i = 0; i < images.getChildrenCount(); i++) {
//                String img0 = images.child("image0").getValue(String.class);
//                String img1 = images.child("image1").getValue(String.class);
//                String img2 = images.child("image2").getValue(String.class);
//                imageList.add(img0);
//                imageList.add(img1);
//                imageList.add(img2);
                imageList.add(images.child("image" + i).getValue(String.class));


//                Log.d("Images", imageList.get(0));
            }
            Log.d("Data", color + "/" + desc + "/"
                    + discPrice + "/" + material + "/" + modelName + "/" + mrpPrice + "/" + occasion
                    + "/" + prodName + "/" + sizes);

            mCategoryData.add(new CategoryProducts(
                    color,
                    desc,
                    modelName,
                    material,
                    occasion,
                    prodName,
                    Integer.parseInt(discPrice),
                    Integer.parseInt(mrpPrice),
                    sizes,
                    thumb,
                    imageList
            ));
        }
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

    }

    class GetData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getInstance().getReference().child("products").child("men").child("belt");

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
}
