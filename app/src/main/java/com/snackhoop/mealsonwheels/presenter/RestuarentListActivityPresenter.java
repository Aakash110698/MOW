package com.snackhoop.mealsonwheels.presenter;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.snackhoop.mealsonwheels.adapter.RestuarentAdapter;
import com.snackhoop.mealsonwheels.adapter.listener.IRestuarentListener;
import com.snackhoop.mealsonwheels.model.RestuarentDetails;
import com.snackhoop.mealsonwheels.presenter.ipresenter.IRestuarentListActivityPresenter;
import com.snackhoop.mealsonwheels.view.iview.IRestuarentListActivityView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by malavan on 23/03/18.
 */

public class RestuarentListActivityPresenter extends BasePresenter<IRestuarentListActivityView> implements IRestuarentListActivityPresenter {


    IRestuarentListActivityView iRestuarentListActivityView;
    List<RestuarentDetails> list = new ArrayList<>();
    public RestuarentListActivityPresenter(IRestuarentListActivityView iView) {
        super(iView);
        this.iRestuarentListActivityView = iView;
    }

    IRestuarentListener<RestuarentDetails> iRestuarentListener = new IRestuarentListener<RestuarentDetails>() {
        @Override
        public void onItemClicked(RestuarentDetails s, int adapterPosition) {
            iRestuarentListActivityView.onClickedForm(s,adapterPosition);
            Log.d(TAG, "onItemClicked: "+s.getArea());

        }

        @Override
        public void onClickItem(int position, RestuarentDetails data) {
            Log.d(TAG, "onClickItem: "+position);

        }
    };



    @Override
    public void onCreatePresenter(Bundle bundle) {

    }

    @Override
    public void callRestuarentAPI(LatLng source,LatLng Destination) {
        if (iRestuarentListActivityView.getCodeSnippet().hasNetworkConnection()){
            iRestuarentListActivityView.showProgressbar();


            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
            databaseReference.child("RestaurentList").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    list = new ArrayList<>();
                   for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                       RestuarentDetails restuarentDetails = dataSnapshot1.getValue(RestuarentDetails.class);
                       list.add(restuarentDetails);
                   }
                   iRestuarentListActivityView.setRestuarentDetails(new RestuarentAdapter(list,iRestuarentListener));
                    iRestuarentListActivityView.dismissProgressbar();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
    @Override
    public void onResumePresenter() {
        super.onResumePresenter();


    }


}
