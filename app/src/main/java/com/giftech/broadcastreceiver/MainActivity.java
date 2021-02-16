package com.giftech.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {
    CustomReceiver mReceiver = new CustomReceiver();
    private static final String ACTION_COSTUM_BROADCAST =
            BuildConfig.APPLICATION_ID+".ACTION_COSTUM_BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        this.registerReceiver(mReceiver, filter);

        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter(ACTION_COSTUM_BROADCAST));
    }

    @Override
    protected void onDestroy() {
        this.unregisterReceiver(mReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    public void sendCostumBroadcast(View view) {
        Intent costumBroadcastIntent = new Intent(ACTION_COSTUM_BROADCAST);
        costumBroadcastIntent.putExtra("DATA", "Data Broadcast");
        LocalBroadcastManager.getInstance(this).sendBroadcast(costumBroadcastIntent);
    }
}