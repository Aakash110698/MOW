package com.snackhoop.mealsonwheels.presenter.ipresenter;

import android.content.Intent;
import android.os.Bundle;

import com.snackhoop.mealsonwheels.library.CustomException;


public interface IBasePresenter {

    void onCreatePresenter(Bundle bundle);

    void onStartPresenter();

    void onStopPresenter();

    void onPausePresenter();

    void onResumePresenter();

    void onDestroyPresenter();

    void onActivityResultPresenter(int requestCode, int resultCode, Intent data);

    void onUnauthorizedAccess(long taskId, CustomException e);
}
