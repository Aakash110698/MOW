package com.snackhoop.mealsonwheels.presenter;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.adapter.FoodMenuAdapter;
import com.snackhoop.mealsonwheels.adapter.listener.IFoodMenuListener;
import com.snackhoop.mealsonwheels.model.FoodMenu;
import com.snackhoop.mealsonwheels.presenter.ipresenter.IMenuFragmentPresenter;
import com.snackhoop.mealsonwheels.view.fragment.BaseFragment;
import com.snackhoop.mealsonwheels.view.iview.IMenuFragementView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malavan on 23/03/18.
 */

public class MenuFragmentPresenter extends BasePresenter<IMenuFragementView> implements IMenuFragmentPresenter {



    private IMenuFragementView iMenuFragementView;
    private List<FoodMenu> foodMenus = new ArrayList<>();
    public MenuFragmentPresenter(IMenuFragementView iView) {
        super(iView);
        this
                .iMenuFragementView  = iView;
    }
    IFoodMenuListener<FoodMenu> iFoodMenuListener = new IFoodMenuListener<FoodMenu>() {
        @Override
        public void onItemClicked(FoodMenu s, int adapterPosition) {
            iMenuFragementView.onMenuIItemClicked(s,adapterPosition);
        }

        @Override
        public void onClickItem(int position, FoodMenu data) {

        }
    };

    @Override
    public void onCreatePresenter(Bundle bundle) {
            String restaurentId = bundle.getString(getStringRes(R.string.restaurantUID));

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child(getStringRes(R.string.restaurantroot));
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                  foodMenus.add(  dataSnapshot1.getValue(FoodMenu.class));
                }
                iMenuFragementView.setAdapter(new FoodMenuAdapter(foodMenus,iFoodMenuListener));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
