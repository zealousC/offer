package com.example.mianshibaodian.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.example.mianshibaodian.R;

public class Utils {
    /**
     * 获取国家码
     */
    public static String getCountryZipCode(Context context) {
        String CountryID = "";
        String CountryZipCode = "";
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        CountryID = manager.getSimCountryIso().toUpperCase();
        Log.d("ss", "CountryID--->>>" + CountryID);
        String[] rl = context.getResources().getStringArray(R.array.CountryCodes);
        for (int i = 0; i < rl.length; i++) {
            String[] g = rl[i].split(",");
            if (g[1].trim().equals(CountryID.trim())) {
                CountryZipCode = g[0];
                break;
            }
        }
        return CountryZipCode;
    }
}
