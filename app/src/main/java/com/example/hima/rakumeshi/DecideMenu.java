package com.example.hima.rakumeshi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hima on 14/09/01.
 */
public class DecideMenu extends Activity{

    NetworkManager networkManager;

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.decide_menu);

        networkManager = new NetworkManager(getApplicationContext());


        String categoryType = getIntent().getStringExtra("categoryType");

        networkManager.setParam("categoryType", categoryType);
        networkManager.getMainDish(new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.d("response", jsonObject.toString());
                try {
                    JSONArray array = jsonObject.getJSONArray("result");
                    for(int i=0; i<array.length(); i++){
                        Log.d("debug", array.get(i).toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
