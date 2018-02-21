package myshoes.com.myshoes.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import myshoes.com.myshoes.model.HomeData;

/**
 * Created by gopinath on 21/02/18.
 */

public class FetchResources {


    public void getData() {
        final ArrayList<HomeData> mHomeData = new ArrayList();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("home").child("xxinffgda");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("home");
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Get map of users in datasnapshot

                        Log.e("FIREBASE DATA", "" + dataSnapshot.getValue());

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });


    }
}
