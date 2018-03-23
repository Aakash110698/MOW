package com.snackhoop.mealsonwheels.view.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.adapter.FoodMenuAdapter;
import com.snackhoop.mealsonwheels.model.FoodMenu;
import com.snackhoop.mealsonwheels.presenter.MenuFragmentPresenter;
import com.snackhoop.mealsonwheels.presenter.ipresenter.IMenuFragmentPresenter;
import com.snackhoop.mealsonwheels.view.iview.IMenuFragementView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends BaseFragment<IMenuFragmentPresenter> implements IMenuFragementView  {


    @BindView(R.id.menu_recyclerview)
    RecyclerView menuList;
    public MenuFragment() {
        super(R.layout.fragment_menu);
    }



    @NonNull
    @Override
    IMenuFragmentPresenter bindView(@Nullable Bundle bundle) {
        bindView();
        return new MenuFragmentPresenter(this);
    }

    private void bindView() {
        ButterKnife.bind(this,rootView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        menuList.setLayoutManager(gridLayoutManager);
        menuList.setHasFixedSize(true);

    }

    @Override
    public void setAdapter(FoodMenuAdapter foodMenuAdapter) {
        menuList.setAdapter(foodMenuAdapter);
    }

    @Override
    public void onMenuIItemClicked(FoodMenu foodMenu, int adapterPosition) {
        //TODO : start menu item activity
        Toast.makeText(getActivity(), foodMenu.getName(), Toast.LENGTH_SHORT).show();
    }
}
