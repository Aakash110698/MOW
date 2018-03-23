package com.snackhoop.mealsonwheels.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.model.LatLng;
import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.adapter.listener.IFoodMenuListener;
import com.snackhoop.mealsonwheels.adapter.viewholder.FoodMenuViewHolder;
import com.snackhoop.mealsonwheels.model.FoodMenu;

import java.util.List;

/**
 * Created by malavan on 23/03/18.
 */

public class FoodMenuAdapter extends BaseRecyclerAdapter<FoodMenu,FoodMenuViewHolder> {

    List<FoodMenu> list;
    IFoodMenuListener<FoodMenu> iFoodMenuListener;

    public FoodMenuAdapter(List<FoodMenu> data, IFoodMenuListener<FoodMenu> iFoodMenuListener) {
        super(data);
        this.list = list;
        this.iFoodMenuListener = iFoodMenuListener;
    }


    @Override
    public FoodMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_restuarent_card,parent,false);
        return new FoodMenuViewHolder(view,list,iFoodMenuListener);
    }
}
