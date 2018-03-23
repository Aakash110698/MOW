package com.snackhoop.mealsonwheels.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.snackhoop.mealsonwheels.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by malavan on 23/03/18.
 */

public class RestaurentBottomsheet extends BaseBottomSheetFragment implements View.OnClickListener {
    @BindView(R.id.edittextdestination)
    TextInputEditText edittextdestination;
    @BindView(R.id.btn_search)
    Button btnSearch;
    Unbinder unbinder;

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_search){
            //TODO Button restaurent activity
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bottomsheet_restaurent;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        btnSearch.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
