package com.snackhoop.mealsonwheels.presenter;

import android.content.Intent;

import com.snackhoop.mealsonwheels.library.CustomException;
import com.snackhoop.mealsonwheels.presenter.ipresenter.IBasePresenter;
import com.snackhoop.mealsonwheels.view.iview.IBaseView;



/**
 * Created by Guru karthik on 06-12-2016
 */

abstract class BasePresenter<T extends IBaseView> implements IBasePresenter {

    protected String TAG = getClass().getSimpleName();

    protected T iView;

    BasePresenter(T iView) {
        this.iView = iView;
    }

    @Override
    public void onStartPresenter() {

    }

    @Override
    public void onStopPresenter() {

    }

    @Override
    public void onPausePresenter() {

    }

    @Override
    public void onResumePresenter() {

    }

    @Override
    public void onDestroyPresenter() {

    }

    @Override
    public void onActivityResultPresenter(int requestCode, int resultCode, Intent data) {

    }
    protected String getStringRes(int res){
        return iView.getActivity().getString(res);
    }

    protected int getIntegerRes(int res){
        return iView.getActivity().getResources().getInteger(res);
    }

    @Override
    public void onUnauthorizedAccess(long taskId, CustomException e) {
        iView.showMessage(e);
        iView.logoutSession();
    }
}
