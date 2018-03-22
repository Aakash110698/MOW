package com.snackhoop.mealsonwheels.view.iview;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.snackhoop.mealsonwheels.library.CustomException;
import com.snackhoop.mealsonwheels.permission.IPermissionProducer;
import com.snackhoop.mealsonwheels.util.CodeSnippet;


public interface IBaseView {

    void showMessage(String message);

    void showMessage(int resId);

    void showMessage(CustomException e);

    void showProgressbar();

    void dismissProgressbar();

    FragmentActivity getActivity();

    void showSnackBar(String message);

    void showSnackBar(@NonNull View view, String message);

    void showNetworkMessage();

    void logoutSession();

    boolean isNetworkEnabled();

    void onClickFullScreen();

    void hideStatusBar();

    void showAlert(String title, String message);

    boolean orientationStatus();

    CodeSnippet getCodeSnippet();

    void callCameraPermissionHandlerForActivity(IPermissionProducer iPermissionProducer, int RequestCode);

}
