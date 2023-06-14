package com.example.uhunt.SharedPref;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utilities {

    static ProgressDialog dialog;
    private Context context;
    public static final String MAP_KEY = "AIzaSyDqCH1HTTLdcchBvgZQf2nAw-lFZ4sXkjE";

    public Utilities(Context context) {
        this.context = context;
    }

    public static final String EMAIL = "userEmail";
    public static final String F_NAME = "first_name";
    public static final String L_NAME = "last_name";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String USER_NAME = "username";
    public static final String USER_ID = "user_id";
    public static final String CITYNAME = "lahore";
    public static final String userType = "userType";
    public static final String APP_TOKEN = "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";
    public static final String USER_PROFILE_IMAGE = "user_profile_img";
    public static final String provider_address = "provider_address";
    public static final String USER_TOKEN = "Bearer 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";

    public static void showProgressDialog(Context ctx, String msg) {
        dialog = new ProgressDialog(ctx);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage(msg);
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public static void hideProgressDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.cancel();
            dialog = null;
        }

    }

    public static void makeToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void saveInt(Context context, String key, int value) {
        SharedPreferences sharedPref = context.getSharedPreferences("PlayerAppSharedStorage", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.apply();


    }

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();


    }

    public static int getInt(Context context, String key) {

        SharedPreferences sharedPref = context.getSharedPreferences("PlayerAppSharedStorage", Context.MODE_PRIVATE);
        int val = sharedPref.getInt(key, 0);
        return val;

    }

//    public static String getAddress(Context context, LatLng latLng) {
//
//        if (latLng == null) {
//            return "";
//        }
//        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
//        List<Address> addresses = new ArrayList<>();
//
//        try {
//            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 3);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (!addresses.isEmpty())
//            return addresses.get(0).getAddressLine(0);
//        else
//            return "";
//    }

    public static void saveString(Context context, String key, String value) {
        SharedPreferences sharedPref = context.getSharedPreferences("PlayerAppSharedStorage", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.apply();

    }

    public static String getString(Context context, String key) {

        SharedPreferences sharedPref = context.getSharedPreferences("PlayerAppSharedStorage", Context.MODE_PRIVATE);
        String val = sharedPref.getString(key, "");

        return val;

    }

    public static String getIsLogin(Context context) {

        String val = Utilities.getString(context, "loginSide");

        return val;

    }

    public static void clearSharedPref(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("PlayerAppSharedStorage", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.clear();
        editor.apply();


    }

    public static void hideKeyboard(View view, Context context) {
        InputMethodManager in = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

    }

    public static String changeDateFormate(String date, String from, String to) {

        String finalDate = date;

//        SimpleDateFormat date_formate = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat date_formate = new SimpleDateFormat(from);

        Date datee = null;
        try {
            datee = date_formate.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }

//        SimpleDateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
        SimpleDateFormat df = new SimpleDateFormat(to);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(datee);
        finalDate = df.format(calendar.getTime());

        return finalDate;

    }

    public static String differenceBetweenDated(String dates_formate, String dateEnd, String dateStr) {

        String days = "";

        SimpleDateFormat sdf = new SimpleDateFormat(dates_formate);

        try {
            Date dateS = sdf.parse(dateStr);
            Date dateE = sdf.parse(dateEnd);

            long diff = dateE.getTime() - dateS.getTime();


            days = String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

        } catch (ParseException e) {
            e.printStackTrace();
        }


        return days;

    }

    public static String getCurrentDate() {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = mdformat.format(calendar.getTime());

        return currentDate;

    }

    public static String formattTwoDecimal(Context context, int number) {


        if (number == 0) {

            return String.valueOf("RS 0.00");
        } else {

            String qa = String.valueOf(number);
            String nocomma = qa.replace(",", "");
            Float f = Float.parseFloat(nocomma);
            String.format("%.2f", f);
            DecimalFormat formatter = new DecimalFormat("#,###,###.00#");
            String yourFormattedString = formatter.format(f);

            return String.valueOf("RS " + yourFormattedString);
        }

    }
//
//
//    public static  void setChildTourModel(Context context, ArrayList<TourModel> pastBookingDataModels) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        globalClass.setChildTourModel(pastBookingDataModels);
//    }
//
//    public static ArrayList<TourModel> getChildTourModel(Context context) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        return  globalClass.getChildTourModel();
//
//    }
//
//    public static  void setCurrentBookingModels(Context context, List<CurrentBookingData> pastBookingDataModels) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        globalClass.setCurrentBookingData(pastBookingDataModels);
//    }
//
//    public static List<CurrentBookingData> getCurrentBookingModels(Context context) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        return globalClass.getCurrentBookingData();
//
//    }
//
//    public static void setNotificationModel(Context context, List<NotificationData> notificationModels) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        globalClass.setNotificationModel(notificationModels);
//    }
//
//    public static List<NotificationData> getNotificationModel(Context context) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        return globalClass.getNotificationModel();
//
//    }
//
//    public static void setHomePageModel(Context context, List<TourModel> notificationModels) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        globalClass.setTourModel(notificationModels);
//    }
//
//
//    public static List<TourModel> getHomePageModel(Context context) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        return globalClass.getTourModel();
//
//    }
//
//    public static void setSearchModel(Context context, List<SearchDataModel> notificationModels) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        globalClass.setSearchModels(notificationModels);
//    }
//
//
//    public static List<SearchDataModel> getSearchModel(Context context) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        return globalClass.getSearchModels();
//
//    }
//
//    public static void setTourProviderModel(Context context, List<TourProviderModel> notificationModels) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        globalClass.setTourProviderModel(notificationModels);
//    }
//
//
//    public static List<TourProviderModel> getTourProvider(Context context) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        return globalClass.getTourProviderModel();
//
//    }
//
//
//    public static void setFeaturedModel(Context context, List<FeaturedModel> notificationModels) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        globalClass.setFeaturedModel(notificationModels);
//    }
//
//
//    public static List<FeaturedModel> getFeaturedModel(Context context) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        return globalClass.getFeaturedModel();
//
//    }
//
//    public static void setPickUpPoints(Context context, ArrayList<PickUpPointsModel> pickUpPointsModelList) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        globalClass.setPickUpPointsModel(pickUpPointsModelList);
//    }
//
//    public static ArrayList<PickUpPointsModel> getPickUpPointsModel(Context context) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        return globalClass.getPickUpPointsModel();
//
//    }
//
//    public static void setPastBookingDetail(Context context, List<PastBookingData> currentBookingData)
//    {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        globalClass.setPastBookingDataModel(currentBookingData);
//    }
//    public static List<PastBookingData> getCurrentBookingDetail(Context context) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        return globalClass.getPastBookingDataModel();
//
//    }
//    public static  void setCurrentToursSData(Context context, List<CurrentTourSData> pastBookingDataModels) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        globalClass.setCurrentToursSData(pastBookingDataModels);
//    }
//
//    public static List<CurrentTourSData> getCurrentToursSData(Context context) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        return globalClass.getCurrentToursSData();
//
//    }
//
//
//    public static  void setPastTourSData(Context context, List<PastTourSData> pastBookingDataModels) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        globalClass.setPassTourSData(pastBookingDataModels);
//    }
//
//    public static List<PastTourSData> getPastTourDataModel(Context context) {
//        GlobalClass globalClass = (GlobalClass) context.getApplicationContext();
//        return globalClass.getPassTourSData();
//
//    }

}
