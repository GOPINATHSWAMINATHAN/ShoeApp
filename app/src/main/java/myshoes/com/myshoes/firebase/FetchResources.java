package myshoes.com.myshoes.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import myshoes.com.myshoes.model.HomeData;

/**
 * Created by gopinath on 21/02/18.
 */

public class FetchResources {


    public List<HomeData> getData() {
        final ArrayList<HomeData> mHomeData = new ArrayList();
        String color;
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("home");
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String color, description, discountPrice, material, modelName, mrpPrice, occassion, prodName, sizeAvailable, star, imageUrl;
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
                            color = homeData.child("color").getValue().toString();
                            description = homeData.child("description").getValue().toString();
                            discountPrice = homeData.child("discountPrice").getValue().toString();
                            material = homeData.child("material").getValue().toString();
                            modelName = homeData.child("modelName").getValue().toString();
                            mrpPrice = homeData.child("mrpPrice").getValue().toString();
                            occassion = homeData.child("occasion").getValue().toString();
                            prodName = homeData.child("prodName").getValue().toString();
                            star = homeData.child("rating").child("star").getValue().toString();
                            sizeAvailable = homeData.child("sizeAvailable").getValue().toString();
                            if (flag == 0) {
                                for (DataSnapshot images : dataSnapshot.getChildren()) {
                                    flag = 1;

                                    for (int i = 1; i <= images.child("image").getChildrenCount(); i++) {

                                        Log.e("Images", "" + images.child("image").child("image" + i).toString());
                                        imageUrl = images.child("image").child("image" + i).toString();
                                        imagesUrl.add(imageUrl);

                                    }


                                }

                            }
                            Log.e("COLOR VALUE IS ", "" + color);
                            mHomeData.add(new HomeData(color, description, modelName, material, occassion, prodName, discountPrice, mrpPrice, sizeAvailable, imagesUrl));
                            ListIterator<HomeData> itr = mHomeData.listIterator();
                            while (itr.hasNext()) {
                                Log.e("MY VALUES AREEEE", "" + itr.next().getColor());
                            }


                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });

        return mHomeData;
    }
}
