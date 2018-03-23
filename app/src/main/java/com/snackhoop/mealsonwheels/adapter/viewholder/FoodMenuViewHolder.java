package com.snackhoop.mealsonwheels.adapter.viewholder;

import android.view.View;

import com.snackhoop.mealsonwheels.adapter.listener.IFoodMenuListener;
import com.snackhoop.mealsonwheels.model.FoodMenu;

import java.util.List;

/**
 * Created by malavan on 23/03/18.
 */

public class FoodMenuViewHolder extends BaseViewHolder<FoodMenu> implements View.OnClickListener {
    List<FoodMenu> foodMenus;
    IFoodMenuListener<FoodMenu> iFoodMenuListener;

    public FoodMenuViewHolder(View itemView, List<FoodMenu> foodMenus, IFoodMenuListener<FoodMenu> iFoodMenuListener) {
        super(itemView);
        this.foodMenus = foodMenus;
        this.iFoodMenuListener = iFoodMenuListener;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    protected void populateData(FoodMenu data) {

    }
}
