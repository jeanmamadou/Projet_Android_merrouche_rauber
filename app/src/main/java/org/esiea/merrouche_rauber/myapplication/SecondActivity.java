package org.esiea.merrouche_rauber.myapplication;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class SecondActivity extends AppCompatActivity {
    private CharactersAdapter CharAdapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characters);
    }
    public JSONArray getCharactersFromFile(){
        try {
            InputStream is = new FileInputStream(getCacheDir() + "/" + "characters.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            JSONArray array = new JSONObject(new String(buffer, "UTF-8")).getJSONArray("objects");
            return array;
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONArray();
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }

    public class CharactersUpdate extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent){
            Log.d("tag",intent.getAction() + "  recu");
            CharAdapt.setNewCharacters(getCharactersFromFile());
        }
    }
}

