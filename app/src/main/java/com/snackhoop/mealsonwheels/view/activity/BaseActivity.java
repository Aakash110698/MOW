package com.snackhoop.mealsonwheels.view.activity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.library.CustomException;
import com.snackhoop.mealsonwheels.library.ExceptionTracker;

import com.snackhoop.mealsonwheels.permission.IPermissionProducer;
import com.snackhoop.mealsonwheels.presenter.ipresenter.IBasePresenter;
import com.snackhoop.mealsonwheels.util.ApplicationSharedPreference;
import com.snackhoop.mealsonwheels.util.CodeSnippet;
import com.snackhoop.mealsonwheels.util.Constants;
import com.snackhoop.mealsonwheels.view.iview.IBaseView;
import com.snackhoop.mealsonwheels.view.widget.CustomProgressbar;

import java.util.Calendar;


abstract class BaseActivity<T extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    protected String TAG = getClass().getSimpleName();
    protected View mParentView;
    protected CodeSnippet mCodeSnippet;
    protected T iPresenter;
    private CustomProgressbar mCustomProgressbar;

    private IPermissionProducer mIPermissionProducer;
    private int mPermissionRequestCode = -1;

    protected Calendar mCalendarParent = Calendar.getInstance();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iPresenter = bindView(savedInstanceState);
        iPresenter.onCreatePresenter(getIntent().getExtras());

    }

    @NonNull
    abstract T bindView(@Nullable Bundle savedInstanceState);


    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        mParentView = getWindow().getDecorView().findViewById(android.R.id.content);
        return super.onCreateView(name, context, attrs);
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (iPresenter != null) iPresenter.onStartPresenter();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (iPresenter != null) iPresenter.onStopPresenter();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (iPresenter != null) iPresenter.onPausePresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (iPresenter != null) iPresenter.onResumePresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (iPresenter != null) iPresenter.onDestroyPresenter();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        showMessage("onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
        if (iPresenter != null) iPresenter.onActivityResultPresenter(requestCode, resultCode, data);
    }


    private CustomProgressbar getProgressBar() {
        if (mCustomProgressbar == null) {
            mCustomProgressbar = new CustomProgressbar(this);
        }
        return mCustomProgressbar;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(CustomException e) {
        Toast.makeText(this, e.getException(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressbar() {
        // TODO have to menu_view_question_preference the custom progressbar
        getProgressBar().show();
    }

    @Override
    public void dismissProgressbar() {
        // TODO dismiss the progressbar
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    getProgressBar().dismissProgress();
                } catch (Exception e) {
                    ExceptionTracker.track(e);
                }
            }
        });
    }

    @Override
    public FragmentActivity getActivity() {
        return BaseActivity.this;
    }

    @Override
    public void showSnackBar(String message) {
        if (mParentView != null) {
            Snackbar snackbar = Snackbar.make(mParentView, message, Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.RED);
            snackbar.show();
        }
    }

    @Override
    public void showSnackBar(@NonNull View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.RED);
        snackbar.show();
    }

    @Override
    public void showNetworkMessage() {
        if (mParentView != null) {
            Snackbar snackbar = Snackbar.make(mParentView, "No Network found!", Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.RED);
            snackbar.setAction(R.string.action_settings, new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mCodeSnippet.showNetworkSettings();
                }
            });
            snackbar.show();
        }
    }

    @Override
    public void logoutSession() {
        dismissProgressbar();
//        ApplicationSharedPreference.getInstance().setUserData(null);
//        ApplicationSharedPreference.getInstance().setPermissionList(null);
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public CodeSnippet getCodeSnippet() {
        if (mCodeSnippet == null) {
            mCodeSnippet = new CodeSnippet(getActivity());
            return mCodeSnippet;
        }
        return mCodeSnippet;
    }

    @Override
    public boolean isNetworkEnabled() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (info != null) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
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
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
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
    public void callCameraPermissionHandlerForActivity(IPermissionProducer iPermissionProducer, int RequestCode) {
        this.mIPermissionProducer = iPermissionProducer;
        this.mPermissionRequestCode = RequestCode;
        if (checkCallingOrSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                checkCallingOrSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                checkCallingOrSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(this,
                        new String[]{
                                Manifest.permission.CAMERA,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE}, mPermissionRequestCode);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{
                                Manifest.permission.CAMERA,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE}, mPermissionRequestCode);
            }
        } else {
            mIPermissionProducer.onReceivedPermissionStatus(mPermissionRequestCode, true);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Constants.Permission.CAMERA_AND_MEDIA_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (mIPermissionProducer != null)
                        mIPermissionProducer.onReceivedPermissionStatus(Constants.Permission.CAMERA_AND_MEDIA_STORAGE, true);
                } else {
                    callCameraPermissionHandlerForActivity(mIPermissionProducer, Constants.Permission.CAMERA_AND_MEDIA_STORAGE);
                }
                break;
        }
    }



    protected Bitmap getBitmapFromImageView(ImageView imageView) {
        Bitmap map = null;
        try {
            imageView.setDrawingCacheEnabled(true);
            imageView.buildDrawingCache();
            map = imageView.getDrawingCache();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
