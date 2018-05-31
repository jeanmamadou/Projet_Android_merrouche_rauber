package org.esiea.merrouche_rauber.myapplication;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.most_popular);
        Button iron = findViewById(R.id.iron_button);
        Button captain = findViewById(R.id.captain_button);
        Button thor = findViewById(R.id.thor_button);
        Button hulk = findViewById(R.id.hulk_button);
        iron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrliron();
            }
        });
        captain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrlcaptain();
            }
        });

        thor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrlthor();
            }
        });

        hulk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrlhulk();
            }
        });
    }

    public void goToUrliron() {
        String url = "http://marvelcinematicuniverse.wikia.com/wiki/Iron_Man";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri u = Uri.parse(url);
        intent.setData(u);
        startActivity(intent);
    }

    public void goToUrlcaptain() {
        String url = "http://marvelcinematicuniverse.wikia.com/wiki/Captain_America";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri u = Uri.parse(url);
        intent.setData(u);
        startActivity(intent);
    }

    public void goToUrlthor() {
        String url = "http://marvelcinematicuniverse.wikia.com/wiki/Thor";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri u = Uri.parse(url);
        intent.setData(u);
        startActivity(intent);
    }

    public void goToUrlhulk() {
        String url = "http://marvelcinematicuniverse.wikia.com/wiki/Hulk";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri u = Uri.parse(url);
        intent.setData(u);
        startActivity(intent);
    }

}

