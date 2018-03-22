package com.snackhoop.mealsonwheels.view.iview;


import com.snackhoop.mealsonwheels.presenter.ipresenter.IBasePresenter;

/**
 * Created by sukumar on 28-11-2017
 */

public interface IBaseBottomSheetView extends IBaseView {
    void bindPresenter(IBasePresenter iBasePresenter);
}
