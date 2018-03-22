package com.snackhoop.mealsonwheels.application;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.util.ApplicationSharedPreference;
import com.snackhoop.mealsonwheels.view.widget.bitmap.CropCircleTransformation;
import com.snackhoop.mealsonwheels.view.widget.bitmap.ImageTransformationType;
import com.snackhoop.mealsonwheels.view.widget.bitmap.RoundedCornersTransformation;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by malavan on 22/03/18.
 */

public class MealsOnWheels extends Application {
    private static MealsOnWheels mAppController;
    public Context mContext;

    public static MealsOnWheels getInstance() {
        return mAppController;
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        Fabric.with(this, new Crashlytics());
//        Fresco.initialize(this);
        mAppController = this;
        initApplication();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private void initApplication() {
        mContext = getApplicationContext();
        ApplicationSharedPreference.initInstance(mContext);
    }

    public ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    //Font family initial

//    private void initApplication() {
//        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/Montserrat-Regular.ttf");
//        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/Montserrat-Bold.ttf");
//        FontsOverride.setDefaultFont(this, "SERIF", "fonts/Montserrat-Regular.ttf");
//        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/Montserrat-Bold.ttf");
//    }

    @NonNull
    public String getBaseUrl() {
        try {
            return getStringFromRes(R.string.base_url);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String getStringFromRes(int resId) throws Exception {
        return getString(resId);
    }

    //shared preference


//    public void setSharedStringData(String key, String value) {
//        SharedPreferences.Editor editor = getEditor();
//        editor.putString(key, value);
//        editor.commit();
//    }
//
//
//    public int getSharedIntData(String key) {
//        return getSharedPreferences().getInt(key, 0);
//    }
//
//    public void setSharedIntData(String key, int value) {
//        SharedPreferences.Editor editor = getEditor();
//        editor.putInt(key, value);
//        editor.commit();
//    }
//
//    public String getSharedStringData(String key) {
//        return getSharedPreferences().getString(key, null);
//    }
//
//    public LoginData getUserData() {
//        return new CodeSnippet(this).getObjectFromJsonString(getSharedStringData(SharedKeys.USER_DATA), LoginData.class);
//    }
//
//    public void setUserData(LoginData loginData) {
//        setSharedStringData(SharedKeys.USER_DATA, new CodeSnippet(this).getJsonStringFromObject(loginData));
//    }
//
//    public String getPermissionList() {
//        return getSharedStringData(SharedKeys.PERMISSION_LIST);
//    }
//
//
//    public void setPermissionList(String permissionList) {
//        setSharedStringData(SharedKeys.PERMISSION_LIST, permissionList);
//    }


    public void loadImageFromNetworkWithoutCrop(Uri imageUri,
                                                ImageView target,
                                                int placeHolder,
                                                ImageTransformationType transformationType) {
        switch (transformationType) {
            case ROUND:
                Glide.with(mAppController)
                        .load(imageUri).placeholder(placeHolder)
                        .crossFade()
                        .bitmapTransform(new CropCircleTransformation(mAppController)).into(target);
                break;
            case ROUNDED_CORNER:
                Glide.with(mAppController)
                        .load(imageUri).placeholder(placeHolder)
                        .crossFade()
                        .bitmapTransform(new RoundedCornersTransformation(mAppController, 5, 0)).into(target);
                break;
            case FLAT_RECTANGLE:
                Glide.with(mAppController)
                        .load(imageUri)
                        .placeholder(placeHolder)
                        .crossFade()
                        .into(target);
                break;
        }
    }

    public void loadImageFromNetworkWithoutCrop(String imageUrl,
                                                ImageView target,
                                                int placeHolder,
                                                ImageTransformationType transformationType) {
        switch (transformationType) {
            case ROUND:
                Glide.with(mAppController)
                        .load(imageUrl).placeholder(placeHolder)
                        .crossFade()
                        .bitmapTransform(new CropCircleTransformation(mAppController)).into(target);
                break;
            case ROUNDED_CORNER:
                Glide.with(mAppController)
                        .load(imageUrl).placeholder(placeHolder)
                        .crossFade()
                        .bitmapTransform(new RoundedCornersTransformation(mAppController, 5, 0)).into(target);
                break;
            case FLAT_RECTANGLE:
                Glide.with(mAppController)
                        .load(imageUrl)
                        .placeholder(placeHolder)
                        .crossFade()
                        .into(target);
                break;
            case FLAT_CENTER_CROPPED:
                Glide.with(mAppController)
                        .load(imageUrl)
                        .placeholder(placeHolder)
                        .crossFade()
                        .centerCrop()
                        .into(target);
                break;
        }
    }

    public void loadImageFromNetworkWithoutCrop(int imageUrl,
                                                ImageView target,
                                                int placeHolder,
                                                ImageTransformationType transformationType) {
        switch (transformationType) {
            case ROUND:
                Glide.with(mAppController)
                        .load(imageUrl).placeholder(placeHolder)
                        .crossFade()
                        .bitmapTransform(new CropCircleTransformation(mAppController)).into(target);
                break;
            case ROUNDED_CORNER:
                Glide.with(mAppController)
                        .load(imageUrl).placeholder(placeHolder)
                        .crossFade()
                        .bitmapTransform(new RoundedCornersTransformation(mAppController, 5, 0)).into(target);
                break;
            case FLAT_RECTANGLE:
                Glide.with(mAppController)
                        .load(imageUrl)
                        .placeholder(placeHolder)
                        .crossFade()
                        .into(target);
                break;
        }
    }


    /**
     * Create a File for saving an image or video
     */
    private File getOutputMediaFile() {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
                + "/Android/data/"
                + getApplicationContext().getPackageName()
                + "/Files");

        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }
        // Create a media file name
        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
        File mediaFile;
        String mImageName = "MI_" + timeStamp + ".jpg";
        mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
        return mediaFile;
    }
}
