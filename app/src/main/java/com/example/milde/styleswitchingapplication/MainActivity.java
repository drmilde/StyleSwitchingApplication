package com.example.milde.styleswitchingapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.nio.BufferUnderflowException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View root = findViewById(android.R.id.content);
        setDefaultLayout(root);

        Button btn_fussball = (Button)findViewById(R.id.btn_fuusball);
        btn_fussball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root.setBackgroundColor(Color.parseColor("#abcdef"));
                ImageView img = (ImageView) findViewById(R.id.imageView);
                img.setImageResource(R.drawable.fussball_01);
            }
        });

        Button btn_kaetzchen = (Button)findViewById(R.id.btn_kaetzchen);
        btn_kaetzchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                root.setBackgroundColor(Color.parseColor("#fedcba"));
                ImageView img = (ImageView) findViewById(R.id.imageView);
                //img.setImageResource(R.drawable.kaetzchen_01);

                int id = getResources().getIdentifier("kaetzchen_01", "drawable", getPackageName());
                img.setImageResource(id);

            }
        });

    }

    private void setDefaultLayout(View root) {
        root.setBackgroundColor(Color.parseColor("#ffff00"));
    }
}
