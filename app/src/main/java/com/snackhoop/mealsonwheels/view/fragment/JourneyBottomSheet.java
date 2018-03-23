package com.snackhoop.mealsonwheels.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.application.Constants;
import com.snackhoop.mealsonwheels.view.activity.RestuarentListActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;
import static com.snackhoop.mealsonwheels.application.Constants.GET_DESTINATION_ACTIVITY;
import static com.snackhoop.mealsonwheels.application.Constants.GET_ORIGIN_ACTIVITY;

/**
 * Created by malavan on 23/03/18.
 */

public class JourneyBottomSheet extends BaseBottomSheetFragment implements View.OnClickListener {
    @BindView(R.id.edittext_origin)
    TextInputEditText edittextOrigin;
    @BindView(R.id.edittextdestination)
    TextInputEditText edittextdestination;
    @BindView(R.id.btn_search)
    Button btnSearch;
    Unbinder unbinder;
    LatLng origin_LatLng;
    LatLng destination_LatLng;

    public JourneyBottomSheet() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bottom_sheet_journey;
    }


    @Override
    public void onClick(View view) {
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
    if (edittextOrigin.getId() == view.getId()){
        try {
            startActivityForResult(builder.build(getActivity()), GET_ORIGIN_ACTIVITY);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }
    else if (edittextdestination.getId() == view.getId()){
        try {
            startActivityForResult(builder.build(getActivity()), GET_DESTINATION_ACTIVITY);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        edittextdestination.setOnClickListener(this);
        edittextOrigin.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_search)
    public void onViewClicked() {
        if (validate()){
            String source = edittextOrigin.getText().toString();
            String destination= edittextdestination.getText().toString();
            Intent intent = new Intent(getActivity(), RestuarentListActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable(getString(R.string.intent_origin_latlng),origin_LatLng);
            bundle.putParcelable(getString(R.string.intent_destination_latlng),destination_LatLng);
            intent.putExtra(getString(R.string.intent_bundle),bundle);
            startActivity(intent);
        }

    }
    public boolean validate(){
        String source = edittextOrigin.getText().toString();
        String destination= edittextdestination.getText().toString();
        if (!TextUtils.isEmpty(source) && !TextUtils.isEmpty(destination)){
            return true;
        }
        return false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            if (requestCode== Constants.GET_ORIGIN_ACTIVITY){
                origin_LatLng = PlacePicker.getPlace(data, getActivity()).getLatLng();
                edittextOrigin.setText(PlacePicker.getPlace(data,getActivity()).getName());

                      }
            else if (requestCode ==GET_DESTINATION_ACTIVITY){
                destination_LatLng = PlacePicker.getPlace(data,getActivity()).getLatLng();
                edittextdestination.setText(PlacePicker.getPlace(data,getActivity()).getName());


            }
        }
    }
}
