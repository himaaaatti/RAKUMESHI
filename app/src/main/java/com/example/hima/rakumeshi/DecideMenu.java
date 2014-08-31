package com.example.hima.rakumeshi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by hima on 14/09/01.
 */
public class DecideMenu extends Activity{

    private NetworkManager networkManager;
//    private ArrayList<RecipeData> recipeData;

    private LinearLayout linearLayout;

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.decide_menu);

        networkManager = new NetworkManager(getApplicationContext());

//        recipeData = new ArrayList<RecipeData>();

        String categoryType = getIntent().getStringExtra("categoryType");

        networkManager.setParam("categoryType", categoryType);
        networkManager.getMainDish(new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                ArrayList<RecipeData> recipeData = new ArrayList<RecipeData>();
                Log.d("response", jsonObject.toString());
                try {
                    JSONArray array = jsonObject.getJSONArray("result");
                    for(int i=0; i<array.length(); i++){
                        Log.d("debug", array.get(i).toString());
                        JSONObject recipe = array.getJSONObject(i);
                        String url = recipe.getString("recipeUrl");
                        String image_url = recipe.getString("foodImageUrl");
                        String title = recipe.getString("recipeTitle");
                        String description = recipe.getString("recipeDescription");
                        String indication = recipe.getString("recipeIndication");
                        String cost = recipe.getString("recipeCost");
                        String nickname = recipe.getString("nickname");

                        recipeData.add(new RecipeData(url, image_url, title, nickname, description, indication, cost));
                        //TODO kururkuru

                    }

                    setRecipes(recipeData);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });



    }

    private void setRecipes(ArrayList<RecipeData> data){
        //TODO: get Image by asynctask, set Image and set Listener to dialog
        //      dynamic adding laytout

        linearLayout = (LinearLayout)findViewById(R.id.top);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NecesaryListDialog dialog = new NecesaryListDialog();
                dialog.show(getFragmentManager(), "dialog");
            }
        });
    }
}
