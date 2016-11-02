package com.lstr.weather.app.datasource.location;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import java.util.List;
import java.util.Locale;

/**
 * Created by LSTR on 11/1/16.
 */
public class GeoLocation {

    Context context;

    public GeoLocation(Context context){
        this.context = context;
    }

    public String getLocationName(double LATITUDE, double LONGITUDE) {
        String strCity = "Lima";
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);

                strCity = returnedAddress.getLocality();
                Log.w("CURR_LOC", "" + strCity);
            } else {
                Log.w("CURR_LOC", "No Address returned!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.w("CURR_LOC", "Canont get Address!");
        }
        return strCity;
    }
}