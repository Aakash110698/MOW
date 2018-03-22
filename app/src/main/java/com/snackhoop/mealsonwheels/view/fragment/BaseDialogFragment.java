package com.snackhoop.mealsonwheels.view.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.snackhoop.mealsonwheels.library.CustomException;
import com.snackhoop.mealsonwheels.permission.IPermissionProducer;
import com.snackhoop.mealsonwheels.presenter.ipresenter.IBasePresenter;
import com.snackhoop.mealsonwheels.util.CodeSnippet;
import com.snackhoop.mealsonwheels.view.iview.IBaseBottomSheetView;
import com.snackhoop.mealsonwheels.view.iview.IBaseView;


public abstract class BaseDialogFragment extends DialogFragment implements IBaseBottomSheetView {
    protected View mParentView;

    protected String TAG = getClass().getSimpleName();
    private IBasePresenter iBasePresenter;

    protected abstract int getLayoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getDialog().getWindow() != null) {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        }

        mParentView = View.inflate(getContext(), getLayoutId(), null);
        return mParentView;
    }

    /* @Override
     public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
         super.onViewCreated(view, savedInstanceState);
         //ButterKnife.bind(this, view);
     }
 */
    @Override
    public void bindPresenter(IBasePresenter iBasePresenter) {
        this.iBasePresenter = iBasePresenter;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (iBasePresenter != null) iBasePresenter.onStartPresenter();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (iBasePresenter != null) iBasePresenter.onPausePresenter();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (iBasePresenter != null) iBasePresenter.onResumePresenter();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (iBasePresenter != null) iBasePresenter.onStopPresenter();
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
    public void showSnackBar(@NonNull View view, String message) {
            ((IBaseView) getActivity()).showSnackBar(view, message);
    }

    @Override
    public void logoutSession() {
            ((IBaseView) getActivity()).logoutSession();
    }

    @Override
    public boolean isNetworkEnabled() {
            return ((IBaseView) getActivity()).isNetworkEnabled();
    }


    @Override
    public void onClickFullScreen() {

    }

    @Override
    public void hideStatusBar() {

    }

    @Override
    public void showAlert(String title, String message) {

    }

    @Override
    public boolean orientationStatus() {
        return false;
    }

    @Override
    public void callCameraPermissionHandlerForActivity(IPermissionProducer iPermissionProducer, int RequestCode) {
            ((IBaseView) getActivity()).callCameraPermissionHandlerForActivity(iPermissionProducer, RequestCode);
    }

    @Override
    public void showMessage(CustomException e) {
            ((IBaseView) getActivity()).showMessage(e);
    }

    @Override
    public CodeSnippet getCodeSnippet() {
        return ((IBaseView) getActivity()).getCodeSnippet();
    }



}
