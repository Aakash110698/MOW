package com.snackhoop.mealsonwheels.util;

/**
 * Created by padma_android on 20-09-2017
 */

public class Constants {

    public static int mScreenWidth = 0;
    public static int mScreenHeight = 0;
    public static int GALLERY_REQUEST_CODE=213;

    public interface HttpCode {
        int SUCCESS_CODE = 200;
        int UN_AUTH_CODE = 403;
    }

    public interface TaskId {
        int MV_VOY_NUMBER = 101;
        int CREATE_PARTICULAR_ITEM = 102;
        int UPDATE_PARTICULAR_ITEM = 103;
        int GET_PARTICULAR_DETAILS = 104;
        int EDIT_PROFILE = 105;
    }

    public interface BundleKey {
        String INCENTIVE_DATA = "IncentiveEditData";
        String INCENTIVE_LIST = "IncentiveListData";
        String GEAR_DATA = "gearData";
        String INCIDENT_DATA = "incidentData";
        String DAMAGE_DATA = "damageData";
        String OVER_TIME_DATA = "overTimeData";
        String VESSEL_FEEDBACK_DATA = "vesselFeedBackData";
    }

    public interface Flag {
        String CREATE_OR_EDIT = "createOrEdit";
        int START_FOR_RESULT = 255;
        int START_FOR_CANCEL = 256;
    }

    public interface Permission {
        int CAMERA_AND_MEDIA_STORAGE = 101;
    }
}
