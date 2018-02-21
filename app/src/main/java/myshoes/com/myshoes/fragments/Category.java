package myshoes.com.myshoes.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myshoes.com.myshoes.R;


/**
 * Created by gopinath on 06/02/18.
 */

public class Category extends Fragment {
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    MyAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View x = inflater.inflate(R.layout.category_fragment, null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabsProduct);
        viewPager = (ViewPager) x.findViewById(R.id.viewpag);

        mAdapter = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(mAdapter);


        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);

            }
        });


        return x;
    }


    public void setItem(int item) {


        viewPager.setCurrentItem(item);

        //viewPager.setCurrentItem(name);

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return the Fragment associated with a specified position.
         *
         * @param position
         */
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new Women();
                case 1:
                    return new Men();
                case 2:
                    return new Kids();

            }
            return null;
        }

        /**
         * Return the number of views available.
         */
        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "Women";
                case 1:
                    return "Men";
                case 2:
                    return "Kids";
            }
            return null;
        }
    }
}


