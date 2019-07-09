package com.jayselle.android_01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ReceptorEstadoRed extends BroadcastReceiver {

    private static final String TAG = "TAG";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Broadcast recibido");

        String action = intent.getAction();
        boolean isAirplaneModeOn = intent.getBooleanExtra("state",false);
        if (action.equals("android.intent.action.AIRPLANE_MODE")){
            if (isAirplaneModeOn){
                Log.i(TAG,"Modo Avion ON");
                Toast.makeText(context,"Modo Avion ON",Toast.LENGTH_SHORT).show();
            } else {
                Log.i(TAG,"Modo Avion OFF");
                Toast.makeText(context,"Modo Avion OFF",Toast.LENGTH_SHORT).show();
            }
        }


    }
}
