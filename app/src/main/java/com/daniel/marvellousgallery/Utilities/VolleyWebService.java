package com.daniel.marvellousgallery.Utilities;

import android.content.Context;
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Web service that use volley dependency
 */

public class VolleyWebService {
    private static String PUBLIC_KEY = "11ca20ba2ec5e30ef6d96c8f71cf452c";
    private static int DEFAULT_TIME = 40000;

    public interface RequestListener {
        void onSucces(String response);
        void onError();
    }

    public static void getCharactersList(final Context context,
                                         ) {}

    //Method to use a get petition in the request
    private static String getUrlParams(Map<String, String> params) {
        List<String> tokens = new ArrayList<>();
        for (String key : params.keySet()) {
            try {
                tokens.add(String.format("%s=%s", key, URLEncoder.encode(params.get(key), "UTF-8")));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return TextUtils.join("&", tokens);
    }

    //Methdo that checks if the response cames with a JSONFile
    private static boolean isExpectedJson(String response) {
        try {
            JSONObject jsonResponse = new JSONObject(response);
            String code = jsonResponse.getString("code");
            if (null == code) {
                return false;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
