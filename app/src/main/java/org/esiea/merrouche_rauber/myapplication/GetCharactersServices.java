package org.esiea.merrouche_rauber.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.nfc.Tag;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.content.ContentValues.TAG;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class GetCharactersServices extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_get_all_characters = "org.esiea.merrouche_rauber.myapplication.action.get_all_characters";
    private static final String ACTION_BAZ = "org.esiea.merrouche_rauber.myapplication.action.BAZ";

    // TODO: Rename parameters
    // private static final String EXTRA_PARAM1 = "org.esiea.merrouche_rauber.myapplication.extra.PARAM1";
    // private static final String EXTRA_PARAM2 = "org.esiea.merrouche_rauber.myapplication.extra.PARAM2";
    // TODO: Rename actions, choose action names that describe tasks that this
    public GetCharactersServices() {
        super("GetCharactersServices");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method

    public static void startActionget_all_characters(Context context) {
        Intent intent = new Intent(context, GetCharactersServices.class);
        intent.setAction(ACTION_get_all_characters);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_get_all_characters.equals(action)) {
                handleActionget_all_characters();
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */

    private void handleActionget_all_characters() {
        // TODO: Handle action get_all_biers
        /*Slog de getcharactersservices*/
        Log.d(TAG, "Thread service name:" + Thread.currentThread().getName());
        Log.i("message","log getCharactersServices");
        URL url = null;
        try {
            url=new URL("https://private-anon-de24744689-jikan.apiary-proxy.com/character/1/pictures"); //
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if(HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
                copyInputStreamToFile(conn.getInputStream(),
                        new File(getCacheDir(),"application/json"));
                Log.d("tag","Characters downloaded");
                LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(MainActivity.CHARACTERS_UPDATE));
            }

        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyInputStreamToFile(InputStream in, File file){
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
