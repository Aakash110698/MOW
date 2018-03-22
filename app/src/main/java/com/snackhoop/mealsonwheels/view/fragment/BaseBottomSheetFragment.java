package com.snackhoop.mealsonwheels.view.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.snackhoop.mealsonwheels.library.CustomException;
import com.snackhoop.mealsonwheels.permission.IPermissionProducer;
import com.snackhoop.mealsonwheels.presenter.ipresenter.IBasePresenter;
import com.snackhoop.mealsonwheels.util.CodeSnippet;
import com.snackhoop.mealsonwheels.view.iview.IBaseBottomSheetView;


/**
 * Created by sukumar on 28-11-2017
 */

public abstract class BaseBottomSheetFragment extends BottomSheetDialogFragment implements IBaseBottomSheetView {

    protected View mParentView;
    private IBasePresenter iPresenter;
    protected String TAG = getClass().getSimpleName();
    View contentView;

    protected abstract int getLayoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

  /*  @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        contentView = View.inflate(getContext(), getLayoutId(), null);
        dialog.setContentView(contentView);
    }*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       /* if (getDialog().getWindow() != null) {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        }*/
        mParentView = View.inflate(getContext(), getLayoutId(), null);
        return mParentView;
    }

   /* @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getDialog().getWindow() != null) {
            getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
            getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogFragmentTheme;
        }
    }*/

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // ButterKnife.bind(this, view);
    }

    @Override
    public void bindPresenter(IBasePresenter iBasePresenter) {
        this.iPresenter = iBasePresenter;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (iPresenter != null) iPresenter.onStartPresenter();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (iPresenter != null) iPresenter.onPausePresenter();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (iPresenter != null) iPresenter.onResumePresenter();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (iPresenter != null) iPresenter.onStopPresenter();
    }

    @Override
    public void showMessage(String message) {
        if (((IBaseBottomSheetView) getActivity()) != null)
            ((IBaseBottomSheetView) getActivity()).showMessage(message);
    }

    @Override
    public void showMessage(int resId) {
        if (((IBaseBottomSheetView) getActivity()) != null)
            ((IBaseBottomSheetView) getActivity()).showMessage(resId);
    }

    @Override
    public void showMessage(CustomException e) {
        if (((IBaseBottomSheetView) getActivity()) != null)
            ((IBaseBottomSheetView) getActivity()).showMessage(e);
    }

    @Override
    public void showProgressbar() {
        if (((IBaseBottomSheetView) getActivity()) != null)
            ((IBaseBottomSheetView) getActivity()).showProgressbar();
    }

    @Override
    public void dismissProgressbar() {
        if (((IBaseBottomSheetView) getActivity()) != null)
            ((IBaseBottomSheetView) getActivity()).dismissProgressbar();
    }

    @Override
    public void showSnackBar(String message) {
        if (((IBaseBottomSheetView) getActivity()) != null)
            ((IBaseBottomSheetView) getActivity()).showSnackBar(message);
    }

    @Override
    public void showNetworkMessage() {
        if (((IBaseBottomSheetView) getActivity()) != null)
            ((IBaseBottomSheetView) getActivity()).showNetworkMessage();
    }

    @Override
    public CodeSnippet getCodeSnippet() {
        return ((IBaseBottomSheetView) getActivity()).getCodeSnippet();
    }

    @Override
    public void showSnackBar(@NonNull View view, String message) {
        if (((IBaseBottomSheetView) getActivity()) != null)
            ((IBaseBottomSheetView) getActivity()).showSnackBar(view, message);
    }


    @Override
    public void logoutSession() {
        if (((IBaseBottomSheetView) getActivity()) != null)
            ((IBaseBottomSheetView) getActivity()).logoutSession();
    }

    @Override
    public boolean isNetworkEnabled() {
        if (((IBaseBottomSheetView) getActivity()) != null)
            return ((IBaseBottomSheetView) getActivity()).isNetworkEnabled();
        else
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

    }

    @Override
    public boolean orientationStatus() {
        return false;
    }

    @Override
    public void callCameraPermissionHandlerForActivity(IPermissionProducer iPermissionProducer, int RequestCode) {
        if (((IBaseBottomSheetView) getActivity()) != null) {
            ((IBaseBottomSheetView) getActivity()).callCameraPermissionHandlerForActivity(iPermissionProducer, RequestCode);
        }
    }
}
