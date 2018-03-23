package com.snackhoop.mealsonwheels.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.adapter.ViewPagerAdapter;
import com.snackhoop.mealsonwheels.presenter.MainPageRestaurentPresenter;
import com.snackhoop.mealsonwheels.presenter.ipresenter.IMainPageRestaurentPresenter;
import com.snackhoop.mealsonwheels.view.iview.IMainPageRestaurentView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by malavan on 23/03/18.
 */

public class MainPageRestaurent extends BaseActivity<IMainPageRestaurentPresenter> implements IMainPageRestaurentView {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.restuarent_img)
    ImageView restuarentImg;
    @BindView(R.id.restuarent_name)
    TextView restuarentName;
    @BindView(R.id.textview_desc)
    TextView textviewDesc;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @NonNull
    @Override
    IMainPageRestaurentPresenter bindView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_main_page_restaurent);
        ButterKnife.bind(this);
        variableInitialization();
        return new MainPageRestaurentPresenter(this);
    }

    private void variableInitialization() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        viewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.restuarent_menu,menu);
         return true;
    }
}
