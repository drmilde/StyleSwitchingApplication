package com.example.milde.styleswitchingapplication;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.nio.BufferUnderflowException;

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
                setDefaultLayout();
            }
        });

        Button btn_kaetzchen = (Button) findViewById(R.id.btn_kaetzchen);
        btn_kaetzchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppState.getInstance().setCurrentStyle(kaetzchen);
                setDefaultLayout();
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

    private void setDefaultLayout() {
        root.setBackgroundColor(getResources().getColor(AppState.getInstance().getStyleId("backgroundColor")));
        ImageView img = (ImageView) findViewById(R.id.imageView);
        img.setImageResource(AppState.getInstance().getStyleId("image1"));
    }


    // activity lifecycle routines ...

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sp = getSharedPreferences("preferences", this.MODE_PRIVATE);
        int currentStyle = sp.getInt("currentStyle", 0);
        AppState.getInstance().setCurrentStyle(currentStyle);
        setDefaultLayout();

        // TODO hier auf die Einstellungen reagieren, also entsprechend das Layout wählen
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp = getSharedPreferences("preferences", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("currentStyle", AppState.getInstance().getCurrentStyle());
        editor.commit();
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
