package com.giftech.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String  ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID+".ACTION_CUSTOM";
    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if(intentAction!= null){
            String toastMessage = "";
            switch (intentAction){
                case  Intent.ACTION_POWER_CONNECTED:
                    toastMessage= context.getString(R.string.power_connected);
                    break;
                case  Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage= "Power Disconnected";
                    break;
                case  ACTION_CUSTOM_BROADCAST:
                    toastMessage= intent.getStringExtra("DATA");
                    break;
            }
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}