package org.esiea.merrouche_rauber.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import static android.content.ContentValues.TAG;


public class CharactersUpdate extends BroadcastReceiver {
    public static final String CHARACTERS_UPDATE = "com.octip.cours.inf4042_11.BIERS_UPDATE";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,getIntent().getAction()); // prévoir une action de notification ici
    }

    /*public Intent getIntent()
        return intent;*/

}