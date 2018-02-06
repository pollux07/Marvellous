package com.daniel.marvellousgallery.Utilities;

import android.annotation.SuppressLint;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Volley instance
 */

public class VolleySingleton {
    @SuppressLint("StaticFieldLeak")
    private static VolleySingleton myInstance;

    private RequestQueue queue;

    @SuppressLint("StaticFieldLeak")
    private static Context mCtx;

    private VolleySingleton(Context context) {
        mCtx = context;
        queue = getRequestQueue();
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (null == myInstance) {
            myInstance = new VolleySingleton(context);
        }

        return myInstance;
    }

    private RequestQueue getRequestQueue() {
        if (null == queue) {
            queue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }

        return queue;
    }

    <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
