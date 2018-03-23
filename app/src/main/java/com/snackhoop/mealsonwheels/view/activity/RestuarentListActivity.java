package com.snackhoop.mealsonwheels.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.adapter.RestuarentAdapter;
import com.snackhoop.mealsonwheels.adapter.listener.IRestuarentListener;
import com.snackhoop.mealsonwheels.model.RestuarentDetails;
import com.snackhoop.mealsonwheels.presenter.RestuarentListActivityPresenter;
import com.snackhoop.mealsonwheels.presenter.ipresenter.IRestuarentListActivityPresenter;
import com.snackhoop.mealsonwheels.view.iview.IRestuarentListActivityView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by malavan on 23/03/18.
 */

public class RestuarentListActivity extends BaseActivity<IRestuarentListActivityPresenter> implements IRestuarentListActivityView {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;




    @NonNull
    @Override
    IRestuarentListActivityPresenter bindView(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_restaurentlist);
        ButterKnife.bind(this);
        initialize();


        return new RestuarentListActivityPresenter(this);
    }


    void initialize() {


//        getPresenter().callRestuarentAPI(null,null);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



    }

    @Override
    public IRestuarentListActivityPresenter getPresenter() {
        return this.iPresenter;
    }

    @Override
    public void setRestuarentDetails(RestuarentAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClickedForm(RestuarentDetails restuarentDetails, int adapterPosition) {
        Toast.makeText(this, ""+restuarentDetails.getArea(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().callRestuarentAPI(null,null);
    }



}
