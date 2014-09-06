package com.example.hima.rakumeshi;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.volley.Response;

import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends Activity {


    private Button menu, pay;
    private Context context;

    private NetworkManager networkManager;

    private Button intentToCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        context = this;

        menu = (Button)findViewById(R.id.menu_btn);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SelectMenuActivity.class);
                startActivity(intent);
            }
        });

        pay = (Button)findViewById(R.id.pay_btn);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PayListActivity.class);
                startActivity(intent);
            }
        });


        intentToCard = (Button)findViewById(R.id.recipe_btn);
        intentToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] strings = new String[] {
                        "日曜日\n", "月曜日\n", "火曜日\n", "水曜日\n", "木曜日\n", "金曜日\n", "土曜日\n"
                };

                Intent intent = new Intent(context, RecipeProcedureActivity.class);
                intent.putExtra("recipeData", strings);

                startActivity(intent);
            }
        });

    }
}
