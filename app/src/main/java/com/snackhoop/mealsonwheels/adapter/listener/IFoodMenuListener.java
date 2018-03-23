package com.snackhoop.mealsonwheels.adapter.listener;

import com.snackhoop.mealsonwheels.model.FoodMenu;

/**
 * Created by malavan on 23/03/18.
 */

public interface IFoodMenuListener<FoodMenu> extends BaseRecyclerAdapterListener<FoodMenu> {
    void onItemClicked(FoodMenu s, int adapterPosition);
}
