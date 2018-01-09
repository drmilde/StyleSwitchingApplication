package com.example.milde.styleswitchingapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private View root = null;

    // style id
    private int fussball = 0;
    private int kaetzchen = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // hole das wurzel element des Layouts (für hintergrundbilder und -farben)
        root = findViewById(android.R.id.content);

        // definiere 2 styles
        initStyles();

        Button btn_fussball = (Button) findViewById(R.id.btn_fuusball);
        btn_fussball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppState.getInstance().setCurrentStyle(fussball);
                setDefaultStyle();
            }
        });

        Button btn_kaetzchen = (Button) findViewById(R.id.btn_kaetzchen);
        btn_kaetzchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppState.getInstance().setCurrentStyle(kaetzchen);
                setDefaultStyle();
            }
        });

    }

    private void initStyles() {
        AppState.getInstance().clearStyles();

        fussball = AppState.getInstance().newStyle("fussball");
        AppState.getInstance().setCurrentStyle(fussball);
        AppState.getInstance().addStyleId("backgroundColor", R.color.colorAccent);
        AppState.getInstance().addStyleId("image1", R.drawable.fussball_01);

        kaetzchen = AppState.getInstance().newStyle("kaetzchen");
        AppState.getInstance().setCurrentStyle(kaetzchen);
        AppState.getInstance().addStyleId("backgroundColor", R.color.colorPrimary);
        AppState.getInstance().addStyleId("image1", R.drawable.kaetzchen_01);

        AppState.getInstance().setCurrentStyle(fussball);
    }


    // style einstellungen vornehmen

    private void setDefaultStyle() {
        root.setBackgroundColor(colorFromID(AppState.getInstance().getStyleId("backgroundColor")));
        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setImageResource(AppState.getInstance().getStyleId("image1"));
    }

    private int colorFromID(int id) {
        return getResources().getColor(id);
    }

    // activity lifecycle routines ...

    @Override
    protected void onResume() {
        super.onResume();

        // laden aus shared preferences
        SharedPreferences sp = getSharedPreferences("preferences", this.MODE_PRIVATE);
        int currentStyle = sp.getInt("currentStyle", 0);
        AppState.getInstance().setCurrentStyle(currentStyle);
        setDefaultStyle();

        // TODO laden der Preferences sollte in AppState passieren !
    }

    @Override
    protected void onPause() {
        super.onPause();

        // speichern in shared preferences
        SharedPreferences sp = getSharedPreferences("preferences", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("currentStyle", AppState.getInstance().getCurrentStyle());
        editor.commit();

        // TODO speichern der Preferences sollte in AppState passieren !
    }


        /*
    private void setTestKaetzchen() {
        root.setBackgroundColor(Color.parseColor("#fedcba"));
        ImageView img = (ImageView) findViewById(R.id.imageView);
        //img.setImageResource(R.drawable.kaetzchen_01);

        int id = getResources().getIdentifier(
                "kaetzchen_01", "drawable",
                getApplicationContext().getPackageName());
        img.setImageResource(id);
    }
    */


}
