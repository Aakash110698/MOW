package com.snackhoop.mealsonwheels.presenter.ipresenter;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by malavan on 23/03/18.
 */

public interface IRestuarentListActivityPresenter extends IBasePresenter {
void callRestuarentAPI(LatLng source, LatLng Destination);
}
