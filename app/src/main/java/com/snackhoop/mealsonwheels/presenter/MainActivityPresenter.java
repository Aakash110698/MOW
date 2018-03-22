package com.snackhoop.mealsonwheels.presenter;

import android.os.Bundle;

import com.snackhoop.mealsonwheels.presenter.ipresenter.ILogInPresenter;
import com.snackhoop.mealsonwheels.presenter.ipresenter.IMainActivityPresenter;
import com.snackhoop.mealsonwheels.view.iview.IMainActivityView;

/**
 * Created by malavan on 22/03/18.
 */

public class MainActivityPresenter extends BasePresenter<IMainActivityView> implements IMainActivityPresenter{
    public MainActivityPresenter(IMainActivityView iView) {
        super(iView);
    }

    @Override
    public void onCreatePresenter(Bundle bundle) {

    }
}
