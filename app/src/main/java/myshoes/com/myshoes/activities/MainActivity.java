package myshoes.com.myshoes.activities;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;

import myshoes.com.myshoes.R;
import myshoes.com.myshoes.animations.BottomNavigationBehavior;
import myshoes.com.myshoes.fragments.Cart;
import myshoes.com.myshoes.fragments.Category;
import myshoes.com.myshoes.fragments.Home;
import myshoes.com.myshoes.fragments.Orders;
import myshoes.com.myshoes.fragments.Profile;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolBar;
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

String firstTitle="Home";


       toolBar= getSupportActionBar();
        SpannableString s = new SpannableString(firstTitle);
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, firstTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
      toolBar.setTitle(s);
        loadFragment(new Home());
         navigation = (BottomNavigationView) findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setItemIconTintList(null);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment fragment;
                    String title="";
                   switch(item.getItemId())
                   {
                       case R.id.home:
                           title="Home";
                           SpannableString s = new SpannableString(title);
                           s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                          toolBar.setTitle(s);
                           fragment=new Home();
                           loadFragment(fragment);

                           return true;
                       case R.id.categories:
                           title="Categories";
                           SpannableString s1 = new SpannableString(title);
                           s1.setSpan(new ForegroundColorSpan(Color.BLACK), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                           toolBar.setTitle(s1);

                           fragment=new Category();
                           loadFragment(fragment);
                          // toolBar.setTitle("Categories");
                           return true;
                       case R.id.cart:
                           title="Cart";
                           SpannableString s2 = new SpannableString(title);
                           s2.setSpan(new ForegroundColorSpan(Color.BLACK), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                           toolBar.setTitle(s2);
                           fragment=new Cart();
                           loadFragment(fragment);
                           //toolBar.setTitle("Cart");
                           return true;
                       case R.id.profile:
                           title="Profile";
                           SpannableString s3 = new SpannableString(title);
                           s3.setSpan(new ForegroundColorSpan(Color.BLACK), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                          toolBar.setTitle(s3);
                           fragment=new Profile();
                           loadFragment(fragment);
                           //toolBar.setTitle("Profile");
                           return true;
                       case R.id.order_history:
                           title="Orders";
                           SpannableString s4 = new SpannableString(title);
                           s4.setSpan(new ForegroundColorSpan(Color.BLACK), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                          toolBar.setTitle(s4);
                           fragment=new Orders();
                           loadFragment(fragment);
                          // toolBar.setTitle("Orders");
                           return true;
                   }

                    return false;
                }
            };

    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
