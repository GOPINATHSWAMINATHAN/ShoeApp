package myshoes.com.myshoes.fragments;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

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

        View x =  inflater.inflate(R.layout.category_fragment,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabsProduct);
        viewPager = (ViewPager) x.findViewById(R.id.viewpag);
final Toolbar toolbar=x.findViewById(R.id.toolbar);

        AppBarLayout appBarLayout = (AppBarLayout)x.findViewById(R.id.appbar);
        appBarLayout.setExpanded(false, false);

        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        mAdapter = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(mAdapter);
        //viewPager.setAdapter(new TabProductFragment.MyAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);

            }
        });
tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int colorFrom = ((ColorDrawable) toolbar.getBackground()).getColor();
        int colorTo = getColorForTab(tab.getPosition());


        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(250);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int color = (int) animation.getAnimatedValue();

                toolbar.setBackgroundColor(color);
                tabLayout.setBackgroundColor(color);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getActivity().getWindow().setStatusBarColor(color);
                }
            }

        });
        colorAnimation.start();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
});

        //  viewPager.setOnPageChangeListener(pageChangeListener);


        return x;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private int getColorForTab(int position) {

        switch (position) {
            case 0:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    return getResources().getColor(R.color.colorPrimaryDark, getActivity().getTheme());
                return getResources().getColor(R.color.colorPrimaryDark);
            case 1:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    return getResources().getColor(R.color.bgTitleLeft, getActivity().getTheme());
                return getResources().getColor(R.color.bgTitleLeft);
            case 2:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    return getResources().getColor(R.color.btnRequest, getActivity().getTheme());
                return getResources().getColor(R.color.btnRequest);
            default:
                return 0;
        }

    }


    /*private ViewPager.OnPageChangeListener pageChangeListener;

    {
        pageChangeListener = new ViewPager.OnPageChangeListener() {

            int currentPosition = 0;

            @Override
            public void onPageSelected(int newPosition) {


              //  mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            public void onPageScrollStateChanged(int arg0) {
            }
        };
    }*/

    public void setItem(int item ){


        viewPager.setCurrentItem(item);

        //viewPager.setCurrentItem(name);

    }
    class MyAdapter extends FragmentPagerAdapter
    {

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

            switch (position){
                case 0 : return new Women();
                case 1 : return new Men();
                case 2 : return new Kids();

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

            switch (position){
                case 0 :
                    return "WOMEN";
                case 1 :
                    return "MEN";
                case 2 :
                    return "KIDS";
            }
            return null;
        }
    }

}
