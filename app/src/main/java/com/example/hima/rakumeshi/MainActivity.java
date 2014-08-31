package com.example.hima.rakumeshi;

import android.app.Activity;
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


public class MainActivity extends Activity {


    private Button menu, pay;
    private Context context;

    private NetworkManager networkManager;

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


//        networkManager = new NetworkManager(this);
//        networkManager.setParam("categoryType", "31");
//        networkManager.getMainDish(new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject jsonObject) {
//                Log.d("debug", jsonObject.toString());
//            }
//        });

    }
}
