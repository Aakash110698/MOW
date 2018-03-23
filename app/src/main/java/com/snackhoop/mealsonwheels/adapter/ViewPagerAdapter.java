package com.snackhoop.mealsonwheels.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.snackhoop.mealsonwheels.view.fragment.InfoFragment;
import com.snackhoop.mealsonwheels.view.fragment.MenuFragment;
import com.snackhoop.mealsonwheels.view.fragment.ReviewFragment;

/**
 * Created by malavan on 23/03/18.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
       switch (position){
           case 0: return new MenuFragment();

           case 1: return new ReviewFragment();

           case 2: return new InfoFragment();

           default:
               return new Fragment();

       }
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
       switch (position){
           case 0: return "Menu";

           case 1: return "Review";

           case 2: return "Info";

           default:
               return "Error";

       }
    }
}
