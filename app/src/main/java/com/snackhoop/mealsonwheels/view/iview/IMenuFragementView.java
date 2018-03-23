package com.snackhoop.mealsonwheels.view.iview;

import com.snackhoop.mealsonwheels.adapter.FoodMenuAdapter;
import com.snackhoop.mealsonwheels.model.FoodMenu;

/**
 * Created by malavan on 23/03/18.
 */

public interface IMenuFragementView extends IFragView {
    void setAdapter(FoodMenuAdapter foodMenuAdapter);
    void onMenuIItemClicked(FoodMenu foodMenu,int adapterPosition);

}
