package com.snackhoop.mealsonwheels.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.snackhoop.mealsonwheels.R;
import com.snackhoop.mealsonwheels.view.activity.LoginActivity;
import com.snackhoop.mealsonwheels.view.widget.CustomTextView;


public class CodeSnippet {

    private String TAG = getClass().getSimpleName();
    private Context mContext;

    public CodeSnippet(Context mContext) {
        this.mContext = mContext;
    }

    public static <T> int getListSize(List<T> list) {
        if (list != null && list.size() > 0) {
            return list.size();
        }
        return 0;
    }

    public static Calendar getCalendarTime(String time) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(formatter.parse(time));
            return calendar;
        } catch (Exception e) {
            Log.d("", "Exception" + e);
        }
        return null;
    }

    public static String getCalendarTime(Calendar time) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
            return formatter.format(time);
        } catch (Exception e) {
            Log.d("", "Exception" + e);
        }
        return null;
    }

    public static String convertTimeAgo(String serverTime) {

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
            Date past = format.parse(serverTime);
            Date now = new Date();
            long seconds = TimeUnit.MILLISECONDS.toSeconds(now.getTime() - past.getTime());
            long minutes = TimeUnit.MILLISECONDS.toMinutes(now.getTime() - past.getTime());
            long hours = TimeUnit.MILLISECONDS.toHours(now.getTime() - past.getTime());
            long days = TimeUnit.MILLISECONDS.toDays(now.getTime() - past.getTime());

            if (seconds < 60) {
                System.out.println(seconds + " seconds ago");
                return seconds + " seconds ago";

            } else if (minutes < 60) {
                System.out.println(minutes + " minutes ago");
                return minutes + " minutes ago";

            } else if (hours < 24) {
                System.out.println(hours + " hours ago");
                return hours + " hours ago";

            } else if (hours < 48) {
                return "Yesterday";

            } else if (days < 7) {
                System.out.println(days + " days ago");
                return days + " days ago";

            } else if (days == 7) {
                return " 1 week ago";

            } else {
                SimpleDateFormat format1 = new SimpleDateFormat("dd MMM", Locale.getDefault());
                System.out.println("Date" + format1.format(past));
                return format1.format(past);
            }
        } catch (Exception j) {
            j.printStackTrace();
        }
        return "";
    }

    public static String formatDateMonthYear(String inputDate) {
        if (inputDate != null) {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault());
            String formatDate = null;
            try {
                Date d = simpleDateFormat.parse(inputDate);
                formatDate = simpleDateFormat2.format(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return formatDate;
        }
        return null;
    }

    public static String formatDateWithSuffix(String inputDate) {
        if (inputDate != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
            String formatDate = null;
            try {
                Date d = simpleDateFormat.parse(inputDate);
                formatDate = getFormattedDate(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return formatDate;
        }
        return null;
    }

    private static String getFormattedDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day = cal.get(Calendar.DATE);
        if (!((day > 10) && (day < 19)))
            switch (day % 10) {
                case 1:
                    return new SimpleDateFormat("d'st' MMMM yyyy", Locale.getDefault()).format(date);
                case 2:
                    return new SimpleDateFormat("d'nd' MMMM yyyy", Locale.getDefault()).format(date);
                case 3:
                    return new SimpleDateFormat("d'rd' MMMM yyyy", Locale.getDefault()).format(date);
                default:
                    return new SimpleDateFormat("d'th' MMMM yyyy", Locale.getDefault()).format(date);
            }
        return new SimpleDateFormat("d'th' MMMM yyyy", Locale.getDefault()).format(date);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {

        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        // drawable.setBounds(canvas.getWidth(), canvas.getHeight(), canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null != activity.getCurrentFocus())
            if (imm != null) {
                imm.hideSoftInputFromWindow(activity.getCurrentFocus()
                        .getApplicationWindowToken(), 0);
            }
    }

    public static String getOrdinaryDate(Calendar calendar) {

        int month = calendar.get(Calendar.MONTH) + 1;
        DecimalFormat formatter = new DecimalFormat("00");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return dateFormat.format(calendar.getTime());
    }
///* Edited dbt me
//    public static void createDrawableIcon(CustomTextView vTDate, CustomTextView vTMv, CustomTextView vTNoGang, CustomTextView vTHatch, CustomTextView vTCreatedBy, CustomTextView vTCreatedOn) {
//        vTDate.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_desc, 0);
//        vTMv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_asc, 0);
//        vTNoGang.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_asc, 0);
//        vTHatch.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_asc, 0);
//        vTCreatedBy.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_asc, 0);
//        vTCreatedOn.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_asc, 0);
//    }
//
//    public static void createDrawableIcon(CustomTextView vTDate, CustomTextView vTMv, CustomTextView vTNoGang, CustomTextView vTHatch, CustomTextView vTFLTModel, CustomTextView vTCreatedBy, CustomTextView vTCreatedOn) {
//        vTDate.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_desc, 0);
//        vTMv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_asc, 0);
//        vTNoGang.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_asc, 0);
//        vTHatch.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_asc, 0);
//        vTFLTModel.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_asc, 0);
//        vTCreatedBy.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_asc, 0);
//        vTCreatedOn.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_sort_asc, 0);
//    }
//
//    public static String getRailwayTime(Calendar calendar) {
//        int min = calendar.get(Calendar.MINUTE);
//        DecimalFormat formatter = new DecimalFormat("00");
//        return formatter.format(calendar.get(Calendar.HOUR_OF_DAY)) + ":" + formatter.format(min);
//    }
//
//    public static void setShiftSpinner(Spinner shiftSpinner, Activity activity) {
//        List<String> mShiftList = Arrays.asList(activity.getResources().getStringArray(R.array.shift));
//
//        ArrayAdapter mShiftAdapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, mShiftList);
//        mShiftAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        shiftSpinner.setAdapter(mShiftAdapter);
//    }
//
//
//    public static void setPortSpinner(Spinner portSpinner, Activity activity) {
//        List<String> mShiftList = Arrays.asList(activity.getResources().getStringArray(R.array.ports));
//        set adapter to spinner
//        ArrayAdapter mShiftAdapter = new ArrayAdapter<>(activity, android.R.layout.simple_spinner_item, mShiftList);
//        mShiftAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        portSpinner.setAdapter(mShiftAdapter);
//    }
//
//    public <T> T getObjectFromJsonString(String jsonString, Class<T> classType) {
//        try {
//            return LoganSquare.parse(jsonString, classType);
//        } catch (IOException | NullPointerException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public <T> String getJsonStringFromObject(T obj) {
//        try {
//            return LoganSquare.serialize(obj);
//        } catch (IOException | NullPointerException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public <T> List<T> getListFromJsonString(String jsonString, Class<T> classType) {
//        try {
//            return LoganSquare.parseList(jsonString, classType);
//        } catch (IOException | NullPointerException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//    */
    @NonNull
    public <T> ArrayList<T> getArrayList(T[] obj) {
        return new ArrayList<>(Arrays.asList(obj));
    }

    /***/
    public String doConvertDateToddMMMyyyy(String time) {
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            final Date dateObj = sdf.parse(time);
            time = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(dateObj);
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /***/
    public Bitmap decodeUri(Uri selectedImage) throws FileNotFoundException {
        // Decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(mContext.getContentResolver().openInputStream(selectedImage), null, o);

        // The new size we want to scale to
        final int REQUIRED_SIZE = 320;

        // Find the correct scale value. It should be the power of 2.
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE
                    || height_tmp / 2 < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        // Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        return BitmapFactory.decodeStream(mContext.getContentResolver().openInputStream(selectedImage), null, o2);
    }

    /***/
    public String getAddressFromLatLng(Context context, double latitude, double longitude) {
        String address = null;
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(context, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            if (addresses.size() > 0) {
                address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address bg_lines by getMaxAddressLineIndex()
                String city = addresses.get(0).getLocality();
                String state = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                String postalCode = addresses.get(0).getPostalCode();
                String knownName = addresses.get(0).getFeatureName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }

    /***/
    public Spannable getSpannableStringWithColor(String str) {
        Spannable spannableString;
        if (str != null) {
            spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, str.length(), 0);
            return spannableString;
        }
        return null;
    }

    /***/
    public String getStringWithSentenceCase(String str) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            if (str.length() > 0) {
                sb.append(Character.toUpperCase(str.charAt(0))).append(str.subSequence(1, str.length()).toString().toLowerCase());
            }
            return sb.toString();
        }
        return null;
    }

    /***/
    public String getCityFromLatLng(Context context, double latitude, double longitude) {
        String city = null;
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(context, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            if (addresses.size() > 0) {
                String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address bg_lines by getMaxAddressLineIndex()
                city = addresses.get(0).getLocality();
                Log.e("Addrss = " + address, "City = " + city);
                String state = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                String postalCode = addresses.get(0).getPostalCode();
                String knownName = addresses.get(0).getFeatureName();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    /***/
    public File getFileFromBitmap(Bitmap bitmap) throws IOException {
//        File f = new File(mContext.getCacheDir(), "" + System.currentTimeMillis() + "_" + gen() + "profile_pic.jpg");
//        File f = new File(mContext.getCacheDir(), "" + System.currentTimeMillis() + "_" + gen() + "profile_pic.jpg");
        File f = new File(mContext.getCacheDir(), "profile_pic.jpg");
        if (f.exists()) {
            f.delete();
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bos);
        byte[] bitmapdata = bos.toByteArray();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(bitmapdata);
        fos.flush();
        fos.close();
        return f;
    }

    /**
     * Check whether the string contains value (OR) not.
     *
     * @param isNotNull string value which has to be checked
     * @return true if the given string is not null and this will validate if the contains
     * "null" as a String value too
     */

    public boolean isNullCheck(String isNotNull) {
        if (isNotNull != null) {
            if (!isNotNull.equalsIgnoreCase("") && isNotNull.length() > 0) {
                if (!isNotNull.equalsIgnoreCase("null")) {
                    return true;
                }
            }
        }
        return false;
    }

    /***/
    private int gen() {
        Random r = new Random(System.currentTimeMillis());
        return 10000 + r.nextInt(20000);
    }

    /***/
    private Date convertStringToDate(String timeStamp, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        Date convertedDate;
        try {
            convertedDate = dateFormat.parse(timeStamp);
            return convertedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***/
    public int getAge(String timeStamp, String format) {
        if (timeStamp != null && timeStamp.trim().length() > 0) {
            int _year, _month, _day;
            Date birthDay = convertStringToDate(timeStamp, format);
            Calendar birthDayCal = Calendar.getInstance();
            birthDayCal.setTime(birthDay);
            _day = birthDayCal.get(Calendar.DAY_OF_MONTH);
            _month = birthDayCal.get(Calendar.MONTH);
            _year = birthDayCal.get(Calendar.YEAR);

            GregorianCalendar cal = new GregorianCalendar();
            int y, m, d, a;
            y = cal.get(Calendar.YEAR);
            m = cal.get(Calendar.MONTH);
            d = cal.get(Calendar.DAY_OF_MONTH);
            cal.set(_year, _month, _day);
            a = y - cal.get(Calendar.YEAR);
            if ((m < cal.get(Calendar.MONTH))
                    || ((m == cal.get(Calendar.MONTH)) && (d < cal
                    .get(Calendar.DAY_OF_MONTH)))) {
                --a;
            }
            if (a < 0)
                throw new IllegalArgumentException("Age < 0");
            return a;
        }
        return 0;
    }

    /**
     * Checking the internet connectivity
     *
     * @return true if the connection is available otherwise false
     */
    public boolean hasNetworkConnection() {
       /* ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                return true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                return true;
            }
        }
        return false;*/

        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        //Patch done by jeeva on 29-03-2016...

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

    /**
     * Get the Android device ID.
     *
     * @param mContext Context of current state of the application/object
     * @return android device id
     */

    public String getAndroidID(Context mContext) {
        return Settings.Secure.getString(mContext.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    /**
     * Check which type of connection the device is connected to
     */
    public boolean isTodayLieInBetween(String str1, String str2) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String todayStr = formatter.format(Calendar.getInstance().getTime());
            Date todayDate = formatter.parse(todayStr);
            Date date1 = formatter.parse(str1);
            Date date2 = formatter.parse(str2);

            return date1.compareTo(todayDate) <= 0 && date2.compareTo(todayDate) >= 0;
        } catch (Exception e) {
            Log.d("Error", "" + e);
        }
        return false;
    }

    /***/
    public boolean isNowLieInBetween(String from, String to) {
        try {
            Date time1 = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).parse(from);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);

            Date time2 = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).parse(to);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(time2);
            calendar2.add(Calendar.DATE, 1);

            String currentDateTimeString = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
            Log.e("Current Date Time", from + "-" + to + "-" + currentDateTimeString);

            Date d = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).parse(currentDateTimeString);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(d);
            calendar3.add(Calendar.DATE, 1);

            Date x = calendar3.getTime();
            if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
                //checkes whether the current time is between 14:49:00 and 20:11:13.
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Calendar getCalendarForYear(String time) {
        try {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy", Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(formatter.parse(time));
            return calendar;
        } catch (Exception e) {
            Log.d("Error", "" + e);
        }
        return null;
    }

    public Calendar getCalendarToStandard(String time) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(formatter.parse(time));
            return calendar;
        } catch (Exception e) {
            Log.d("Error", "" + e);
        }
        return null;
    }

    public Calendar getCalendarWithTimeOnly(String time) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa", Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(formatter.parse(time));
            return calendar;
        } catch (Exception e) {
            SimpleDateFormat formatter = new SimpleDateFormat("hh : mm aa", Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            try {
                calendar.setTime(formatter.parse(time));
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            return calendar;
        }
    }

    public String getDayOfMonthMonthAndYear(Calendar calendar) {
        //TODO mention
        String dateString;
        dateString = calendar.get(Calendar.DAY_OF_MONTH) + " " + getMonthNameFromInt(calendar.get(Calendar.MONTH)) + ", " + calendar.get(Calendar.YEAR);
        return dateString;
    }

    public String getDayOfMonthMonthAndYearStd(Calendar calendar) {
        String dateString;
        int month = calendar.get(Calendar.MONTH) + 1;
        DecimalFormat formatter = new DecimalFormat("00");
        dateString = formatter.format(calendar.get(Calendar.DAY_OF_MONTH)) + "-" + formatter.format(month) + "-" + calendar.get(Calendar.YEAR);
        return dateString;
    }

    /***/
    private String getMonthNameFromInt(int monthInt) {
        String month = "";
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        if (monthInt >= 0 && monthInt <= 11) {
            month = months[monthInt];
        }
        return month.substring(0, 3);
    }

    /***/
    public boolean isValidDate(int year, int month, int day) {
        try {
            Calendar selectedCalendar = Calendar.getInstance();
            selectedCalendar.set(year, month, day);
            Date selectedDate = selectedCalendar.getTime();

            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
            Date currentdate = sdf.parse(sdf.format(date));

            System.out.println(sdf.format(currentdate));
            System.out.println(sdf.format(selectedDate));

            return selectedDate.equals(currentdate) | selectedDate.after(currentdate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public String getPastTimerString(Calendar calendar) {
        long time = System.currentTimeMillis() - calendar.getTimeInMillis();
        long mins = time / 60000;
        if (mins > 59L) {
            long hours = mins / 60;
            if (hours > 24) {
                long days = hours / 24;
                if (days > 1) {
                    return days + " days";
                } else {
                    return days + " day";
                }
            } else {
                return hours + " hours ago";
            }
        } else {
            return "less than a minute";
        }
    }

    public Date getTimeFromMilisecond(long timeStamp) {
        return new Date(timeStamp * 1000);
    }

    public String getOrdinaryTime(Time time) {
        if (time.hour > 12) {
            return formatTime(time.hour - 12) + ":" + formatTime(time.minute)
                    + " " + getAMorPM(time);
        }

        return (time.hour == 0 ? String.valueOf(12) : formatTime(time.hour)) + ":"
                + formatTime(time.minute) + " " + getAMorPM(time);
    }

    public String getOrdinaryDateWithFipe(Time date) {

        return date.monthDay + " | " + date.month + " | " + date.year;
    }

    private String formatTime(int time) {
        if (String.valueOf(time).length() < 2)
            return "0" + time;
        else
            return String.valueOf(time);
    }

    private String getAMorPM(Time time) {
        String AM = "AM";
        if (time.hour > 11) {
            String PM = "PM";
            return PM;
        } else
            return AM;
    }

    private void showGooglePlayDialog(final Context context, final OnGooglePlayServiceListener googlePlayServiceListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Get Google Play Service");
        builder.setMessage("This app won't run without Google Play Services, which are missing from your phone");
        builder.setPositiveButton("Get Google Play Service",
                (dialog, which) -> {
                    googlePlayServiceListener.onInstallingService();
                    context.startActivity(new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?"
                                    + "id=com.google.android.gms")));
                    dialog.dismiss();
                });
        builder.setNegativeButton("Cancel", (dialog, which) -> googlePlayServiceListener.onCancelServiceInstallation());
        builder.setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }

    private Intent getSettingsIntent(String settings) {
        return new Intent(settings);
    }

    private void startActivityBySettings(Context context, String settings) {
        context.startActivity(getSettingsIntent(settings));
    }

    private void startActivityBySettings(Context context, Intent intent) {
        context.startActivity(intent);
    }

    public void showNetworkSettings() {
        Intent chooserIntent = Intent.createChooser(getSettingsIntent(Settings.ACTION_DATA_ROAMING_SETTINGS),
                "Complete action using");
        List<Intent> networkIntents = new ArrayList<>();
        networkIntents.add(getSettingsIntent(Settings.ACTION_WIFI_SETTINGS));
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, networkIntents.toArray(new Parcelable[]{}));
        startActivityBySettings(mContext, chooserIntent);
    }

    public boolean isSpecifiedDelay(long exisingTime, long specifiedDelay) {
        return specifiedDelay >= (Calendar.getInstance().getTimeInMillis() - exisingTime);
    }

    public void showKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null != activity.getCurrentFocus())
            if (imm != null) {
                imm.showSoftInputFromInputMethod(activity.getCurrentFocus()
                        .getApplicationWindowToken(), 0);
            }
    }

    public boolean isNull(Object object) {
        return null == object || object.toString().compareTo("null") == 0;
    }

    public final boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public boolean isAboveMarshmallow() {
        int currentapiVersion = Build.VERSION.SDK_INT;
        // Do something for marshmallow and above versions
// do something for phones running an SDK before marshmallow
        return currentapiVersion >= Build.VERSION_CODES.M;
    }

    public boolean isAboveLollipop() {
        int currentapiVersion = Build.VERSION.SDK_INT;
        // Do something for marshmallow and above versions
// do something for phones running an SDK before marshmallow
        return currentapiVersion >= Build.VERSION_CODES.LOLLIPOP;
    }

    /**
     * Fetch the drawable object for the given resource id.
     *
     * @param resourceId to which the value is to be fetched.
     * @return drawable object for the given resource id.
     */
    public Drawable getDrawable(int resourceId) {
        return ResourcesCompat.getDrawable(mContext.getResources(), resourceId, null);
    }

    /**
     * Returns the current date.
     *
     * @return Current date
     */
    public Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * Fetch the string value from a xml file returns the value.
     *
     * @param resId to which the value has to be fetched.
     * @return String value of the given resource id.
     */
    public String getString(int resId) {
        return mContext.getResources().getString(resId);
    }

    /**
     * Fetch the color value from a xml file returns the value.
     *
     * @param colorId to which the value has to be fetched.
     * @return Integer value of the given resource id.
     */
    public int getColor(int colorId) {
        return ContextCompat.getColor(mContext, colorId);
    }

    /**
     * Checks whether the device currently has a network connection..
     *
     * @param activity Activity of current state of the application/object
     * @return true if the device has a network connection, false otherwise.
     */
    public boolean isDeviceOnLine(Activity activity) {
        ConnectivityManager connectivity = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        Toast.makeText(activity, R.string.alert_network_error, Toast.LENGTH_SHORT).show();
        return false;
    }

    /***/
    public String roundOff(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return "" + ((double) tmp / factor) + " Km";
    }

    /***/
    public String getTimeIn12HrsFormat(String time) {
        String convertedTime = null;
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
            final Date dateObj = sdf.parse(time);
            System.out.println(dateObj);
            convertedTime = new SimpleDateFormat("KK:mm a", Locale.getDefault()).format(dateObj);
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return convertedTime;
    }

    public String formatDateWithDay(String inputDate) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM dd,yyyy", Locale.getDefault());//EEE dd MMM//MMM dd
        String formatDate = null;
        try {
            Date d = simpleDateFormat.parse(inputDate);
            formatDate = simpleDateFormat2.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate;
    }

    public File getFileFromBitmap(Bitmap bitmap, Context context, String imageName) throws IOException {
        File f = null;
        if (bitmap != null) {
            f = new File(context.getCacheDir(), "" + System.currentTimeMillis() + "_" + gen() + imageName + ".png");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap = compressBitmap(bitmap);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100 /*ignored for PNG*/, bos);
            byte[] bitmapdata = bos.toByteArray();
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
        } else {
            Log.d(TAG, "Selected Bit map is null");
        }
        return f;
    }

    private Bitmap compressBitmap(Bitmap mBitmap) {
        int maxSize = 300;
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 0) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        mBitmap = Bitmap.createScaledBitmap(mBitmap, width, height, true);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
        return mBitmap;
    }

    public int convertToMilli(long hour, long min, long sec) {
        return (int) (TimeUnit.HOURS.toMillis(hour) + TimeUnit.MINUTES.toMillis(min) + TimeUnit.SECONDS.toMillis(sec));
    }

    public void logout(final Context context) {

        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        builder.setTitle("Logged out");
        builder.setMessage("Your id has been logged in on another device");
        builder.setPositiveButton("Ok",
                (dialog, which) -> {
                    //ApplicationSharedPreference.getInstance().setUserData(null);
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    dialog.dismiss();
                });
        builder.setCancelable(false);
        android.support.v7.app.AlertDialog alert = builder.create();
        alert.show();

    }

    private interface OnGooglePlayServiceListener {
        void onInstallingService();

        void onCancelServiceInstallation();
    }

}