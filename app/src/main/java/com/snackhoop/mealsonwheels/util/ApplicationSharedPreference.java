package com.snackhoop.mealsonwheels.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.application.MealsOnWheels;

/**
 * Created by bhakiyalakshmi on 23-11-2017
 */

public class ApplicationSharedPreference {

    private static ApplicationSharedPreference preferenceInstance;
    private static SharedPreferences mSharedPreferences;
    private Context mContext;

    private ApplicationSharedPreference(Context context) {
        super();
        this.mContext = context;
    }


    public static void initInstance(Context context) {
        if (preferenceInstance == null) {
            preferenceInstance = new ApplicationSharedPreference(context);
            mSharedPreferences = context.getSharedPreferences(context.getPackageName(),
                    Context.MODE_PRIVATE);

        }
    }

    public static ApplicationSharedPreference getInstance() {
        return preferenceInstance;
    }


    private SharedPreferences getSharedPreferences() {
        return mSharedPreferences;
    }

    private SharedPreferences.Editor getEditor() {
        return mSharedPreferences.edit();
    }


    private void setSharedStringData(String key, String value) {
        SharedPreferences.Editor editor = getEditor();
        editor.putString(key, value);
        editor.commit();
    }


    public int getSharedIntData(String key) {
        return getSharedPreferences().getInt(key, 0);
    }

    public void setSharedIntData(String key, int value) {
        SharedPreferences.Editor editor = getEditor();
        editor.putInt(key, value);
        editor.commit();
    }

    public String getSharedStringData(String key) {
        return getSharedPreferences().getString(key, null);
    }

//    public LoginData getUserData() {
//        return new CodeSnippet(mContext).getObjectFromJsonString(getSharedStringData(com.indopacific.application.Constants.SharedKeys.USER_DATA), LoginData.class);
//    }
//
//    public void setUserData(LoginData loginData) {
//        setSharedStringData(com.indopacific.application.Constants.SharedKeys.USER_DATA, new CodeSnippet(mContext).getJsonStringFromObject(loginData));
//    }
//
//    public String getPermissionList() {
//        return getSharedStringData(com.indopacific.application.Constants.SharedKeys.PERMISSION_LIST);
//    }
//
//
//    public void setPermissionList(String permissionList) {
//        setSharedStringData(com.indopacific.application.Constants.SharedKeys.PERMISSION_LIST, permissionList);
//    }
//
//    public void setLoggedUserName(String name) {
//        SharedPreferences.Editor editor = getEditor();
//        editor.putString(MealsOnWheels.getInstance().getString(R.string.logged_user_name), name);
//        editor.commit();
//    }
//
//    public String getLoggedUserName() {
//        return getSharedPreferences().getString(IndoPacificApplication.getInstance().getString(R.string.logged_user_name), null);
//    }


}


