package com.snackhoop.mealsonwheels.presenter;

import android.os.Bundle;

import com.snackhoop.mealsonwheels.presenter.ipresenter.ILogInPresenter;
import com.snackhoop.mealsonwheels.view.iview.ILogInView;

/**
 * Created by malavan on 22/03/18.
 */

public class LogInPresenter extends BasePresenter<ILogInView> implements ILogInPresenter {

    public LogInPresenter(ILogInView iView) {
        super(iView);
    }

    @Override
    public void onCreatePresenter(Bundle bundle) {

    }
}
