package com.snackhoop.mealsonwheels.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snackhoop.mealsonwheels.library.CustomException;
import com.snackhoop.mealsonwheels.library.LayoutCannotResolve;
import com.snackhoop.mealsonwheels.library.Log;
import com.snackhoop.mealsonwheels.permission.IPermissionProducer;
import com.snackhoop.mealsonwheels.presenter.ipresenter.IBasePresenter;
import com.snackhoop.mealsonwheels.util.ApplicationSharedPreference;
import com.snackhoop.mealsonwheels.util.CodeSnippet;
import com.snackhoop.mealsonwheels.view.iview.IBaseView;
import com.snackhoop.mealsonwheels.view.iview.IFragView;


public abstract class BaseFragment<T extends IBasePresenter> extends Fragment implements IFragView {

    protected String TAG = getClass().getSimpleName();
//    private IBasePresenter iBasePresenter;
//    public int mOrientation = Configuration.ORIENTATION_PORTRAIT;
//
//
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        if (iBasePresenter != null) iBasePresenter.onStartPresenter();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (iBasePresenter != null) iBasePresenter.onStopPresenter();
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        if (iBasePresenter != null) iBasePresenter.onPausePresenter();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        if (iBasePresenter != null) iBasePresenter.onResumePresenter();
//    }
//
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (iBasePresenter != null)
//            iBasePresenter.onActivityResultPresenter(requestCode, resultCode, data);
//
//    }
//
//
//    @Override
//    public void showMessage(String message) {
//        if (((IBaseView) getActivity()) != null) {
//            ((IBaseView) getActivity()).showMessage(message);
//        }
//    }
//
//    @Override
//    public void showMessage(int resId) {
//        if (((IBaseView) getActivity()) != null)
//            ((IBaseView) getActivity()).showMessage(resId);
//    }
//
//   /* @Override
//    public void showMessage(CustomException e) {
//        if (((IBaseView) getActivity()) != null)
//            ((IBaseView) getActivity()).showMessage(e);
//    }*/
//
//    @Override
//    public void showProgressbar() {
//        if (((IBaseView) getActivity()) != null)
//            ((IBaseView) getActivity()).showProgressbar();
//    }
//
//    @Override
//    public void dismissProgressbar() {
//        if (((IBaseView) getActivity()) != null)
//            ((IBaseView) getActivity()).dismissProgressbar();
//    }
//
//    @Override
//    public void showSnackBar(String message) {
//        if (((IBaseView) getActivity()) != null)
//            ((IBaseView) getActivity()).showSnackBar(message);
//    }
//
//    @Override
//    public void showNetworkMessage() {
//        if (((IBaseView) getActivity()) != null)
//            ((IBaseView) getActivity()).showNetworkMessage();
//    }
//
// /*   @Override
//    public CodeSnippet getCodeSnippet() {
//       *//* if (((IBaseView) getActivity()) != null)
//            return ((IBaseView) getActivity()).getCodeSnippet();
//        return null;*//*
//        return ((IBaseView) getActivity()).getCodeSnippet();
//    }*/
//
//    @Override
//    public void showSnackBar(@NonNull View view, String message) {
//        if (((IBaseView) getActivity()) != null)
//            ((IBaseView) getActivity()).showSnackBar(view, message);
//    }
//
//    @Override
//    public void logoutSession() {
//        if (((IBaseView) getActivity()) != null)
//            ((IBaseView) getActivity()).logoutSession();
//    }
//
//    public String getDuration(VideoView mp) {
//        int duration = mp.getDuration() / 1000;
//        int hours = duration / 3600;
//        int minutes = (duration / 60) - (hours * 60);
//        int seconds = duration - (hours * 3600) - (minutes * 60);
//        return String.format("%02d:%02d", minutes, seconds);
//    }
//
//    public String getDurations(VideoView mp) {
//        int duration = mp.getCurrentPosition() / 1000;
//        int hours = duration / 3600;
//        int minutes = (duration / 60) - (hours * 60);
//        int seconds = duration - (hours * 3600) - (minutes * 60);
//        return String.format("%02d:%02d", minutes, seconds);
//    }
//
//    @Override
//    public boolean isNetworkEnabled() {
//        if (((IBaseView) getActivity()) != null)
//            return ((IBaseView) getActivity()).isNetworkEnabled();
//        else
//            return false;
//    }
//
//
//    @Override
//    public void onClickFullScreen() {
//        if (((IBaseView) getActivity()) != null)
//            ((IBaseView) getActivity()).onClickFullScreen();
//    }
//
//    @Override
//    public void hideStatusBar() {
//        if (((IBaseView) getActivity()) != null)
//            ((IBaseView) getActivity()).hideStatusBar();
//    }
//
//    @Override
//    public boolean orientationStatus() {
//        if (((IBaseView) getActivity()) != null)
//            return ((IBaseView) getActivity()).orientationStatus();
//        else
//            return false;
//    }
//
//    @Override
//    public CodeSnippet getCodeSnippet() {
//        return null;
//    }

    protected View rootView;
    protected T iPresenter;
    private int layoutRes = -1;

    public BaseFragment(int layoutRes) {
        this.layoutRes = layoutRes;
    }

    public void setContentView(int layoutRes) {
        this.layoutRes = layoutRes;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            checkForLayout();
        } catch (LayoutCannotResolve layoutCannotResolve) {
            layoutCannotResolve.printStackTrace();
        }
        if (layoutRes != 0 && layoutRes != -1) {
            rootView = inflater.inflate(layoutRes, container, false);
        }
        iPresenter = bindView(savedInstanceState);
        iPresenter.onCreatePresenter(getArguments());
        return rootView;
    }

    @NonNull
    abstract T bindView(@Nullable Bundle bundle);

    private void checkForLayout() throws LayoutCannotResolve {
        if (layoutRes == -1) {
            throw new LayoutCannotResolve(TAG, "You have missed to invoke setContentView method with layout!");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "requestCode: " + requestCode);
        super.onActivityResult(requestCode, resultCode, data);
        if (iPresenter != null) iPresenter.onActivityResultPresenter(requestCode, resultCode, data);
    }

    @Override
    public void showMessage(String message) {
        ((IBaseView) getActivity()).showMessage(message);
    }

    @Override
    public void showMessage(int resId) {
        ((IBaseView) getActivity()).showMessage(resId);
    }

    @Override
    public void showMessage(CustomException e) {
        ((IBaseView) getActivity()).showMessage(e);
    }

    @Override
    public void showProgressbar() {
        ((IBaseView) getActivity()).showProgressbar();
    }

    @Override
    public void dismissProgressbar() {
        ((IBaseView) getActivity()).dismissProgressbar();
    }

    @Override
    public void showSnackBar(String message) {
        ((IBaseView) getActivity()).showSnackBar(message);
    }

    @Override
    public void showNetworkMessage() {
        ((IBaseView) getActivity()).showNetworkMessage();
    }

    @Override
    public CodeSnippet getCodeSnippet() {
        return ((IBaseView) getActivity()).getCodeSnippet();
    }

    @Override
    public void showSnackBar(@NonNull View view, String message) {
        ((IBaseView) getActivity()).showSnackBar(view, message);
    }

    @Override
    public void logoutSession() {
        dismissProgressbar();
//        ApplicationSharedPreference.getInstance().setUserData(null);
//        ApplicationSharedPreference.getInstance().setPermissionList(null);
//        Intent intent = new Intent(getActivity(), LoginActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
    }

    @Override
    public boolean isNetworkEnabled() {
        return false;
    }

    @Override
    public void onClickFullScreen() {

    }

    @Override
    public void hideStatusBar() {

    }

    @Override
    public void showAlert(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Yes",
                (dialog, which) -> {
                    logoutSession();
                    dialog.dismiss();
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No",
                (dialog, which) -> dialog.dismiss());
        alertDialog.show();
    }

    @Override
    public boolean orientationStatus() {
        return false;
    }

    @Override
    public Fragment getFragment() {
        return this;
    }

    @Override
    public void callCameraPermissionHandlerForActivity(IPermissionProducer iPermissionProducer, int RequestCode) {
        if (((IBaseView) getActivity()) != null) {
            ((IBaseView) getActivity()).callCameraPermissionHandlerForActivity(iPermissionProducer, RequestCode);
        }
    }
}
