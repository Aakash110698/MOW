package com.snackhoop.mealsonwheels.presenter;

import android.os.Bundle;

import com.snackhoop.mealsonwheels.adapter.listener.IFoodMenuListener;
import com.snackhoop.mealsonwheels.model.FoodMenu;
import com.snackhoop.mealsonwheels.presenter.ipresenter.IMainPageRestaurentPresenter;
import com.snackhoop.mealsonwheels.view.iview.IMainPageRestaurentView;

/**
 * Created by malavan on 23/03/18.
 */

public class MainPageRestaurentPresenter extends BasePresenter<IMainPageRestaurentView> implements IMainPageRestaurentPresenter {
    public MainPageRestaurentPresenter(IMainPageRestaurentView iView) {
        super(iView);
    }


    IFoodMenuListener<FoodMenu> iFoodMenuListener = new IFoodMenuListener<FoodMenu>() {
        @Override
        public void onItemClicked(FoodMenu s, int adapterPosition) {

        }

        @Override
        public void onClickItem(int position, FoodMenu data) {

        }
    };
    @Override
    public void onCreatePresenter(Bundle bundle) {

    }
}
