package com.example.omer3.configureddialogome;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    AlertDialog.Builder adb;
    LinearLayout l1;
    Random rnd = new Random();
    int R1,G1,B1;
    final String[] colors={"red","green","blue"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        l1 = (LinearLayout) findViewById(R.id.l1);
    }

    public void change(View view) {
        final int[] color = new int[]{0,0,0};
        adb = new AlertDialog.Builder(this);
        adb.setTitle("list of color");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which]=255;
                l1.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void mix(View view) {
        final int[] color = new int[]{0,0,0};
        adb = new AlertDialog.Builder(this);
        adb.setTitle("list of color");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked) color[which]=255;
                else if (color[which]==255) color[which]=1;
            }
        });
        adb.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                l1.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();

    }

    public void reset(View view) {
        l1.setBackgroundColor(Color.WHITE);

    }


    public boolean onCreateOptionsMenu (Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item){

        int nextActivity = item.getItemId();
        if (nextActivity == R.id.nextAtivity) {
            Intent go = new Intent(this, Main2Activity.class);
            startActivity(go);
        }

        return true;

    }







}
