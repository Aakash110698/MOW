package com.snackhoop.mealsonwheels.permission;

/**
 * Created by sukumar on 30-11-2017
 */

public interface IPermissionProducer {
    void onReceivedPermissionStatus(int code, boolean isGranted);
}
