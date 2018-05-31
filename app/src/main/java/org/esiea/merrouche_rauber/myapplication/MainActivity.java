package org.esiea.merrouche_rauber.myapplication;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String CHARACTERS_UPDATE = "com.octip.cours.inf4042_11.BIERS_UPDATE";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button characters = findViewById(R.id.characters_button);
        Button most_popular = findViewById(R.id.most_popular_button);
        Button help = findViewById(R.id.help_button);
        characters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondActivity();
            }
        });
        most_popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openThirdActivity();
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helptoast();
            }
        });
    }


    public void openSecondActivity(){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    public void openThirdActivity(){
        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
        startActivity(intent);
    }

    public void helptoast() {
        Toast toast = Toast.makeText(this,"avez vous besoin d'aide ?",5);
        toast.show();
    }
}
