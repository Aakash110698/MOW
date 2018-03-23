package com.snackhoop.mealsonwheels.presenter;

import android.os.Bundle;

import com.snackhoop.mealsonwheels.presenter.ipresenter.IJourneyBottomSheetPresenter;
import com.snackhoop.mealsonwheels.view.iview.IJournetBottomSheetView;

/**
 * Created by malavan on 23/03/18.
 */

public class JourneyBottomSheetPresenter extends BasePresenter<IJournetBottomSheetView> implements IJourneyBottomSheetPresenter {
    public JourneyBottomSheetPresenter(IJournetBottomSheetView iView) {
        super(iView);
    }

    @Override
    public void onCreatePresenter(Bundle bundle) {

    }

}
