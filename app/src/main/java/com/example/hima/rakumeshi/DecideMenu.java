package com.example.hima.rakumeshi;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
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
        if(categoryType.equals("free")){
            categoryType="30";
        }
        networkManager.setParam("categoryType", categoryType);
        networkManager.getMainDish(new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                ArrayList<RecipeData> recipeData = new ArrayList<RecipeData>();
                Log.d("response", jsonObject.toString());
                try {
                    JSONArray array = jsonObject.getJSONArray("result");
                    for(int i=0; i<array.length(); i++){
//                        Log.d("debug", array.get(i).toString());
//                      for(int i=0; i==1; i++){
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
                    Log.v("error","error");
                    e.printStackTrace();
                }

            }
        });



    }
    private void selectRecipe(){

    }

    private void setRecipes(ArrayList<RecipeData> data){
        //TODO: get Image by asynctask, set Image and set Listener to dialog
        //      dynamic adding laytout

        linearLayout = (LinearLayout)findViewById(R.id.top);
        final ImageView ivmenu = (ImageView)findViewById(R.id.menuImage);
        TextView tvmenu = (TextView)findViewById(R.id.menuName);
        Log.d("debug", "size " + String.valueOf(data.size()));

        new AsyncTask<String, String, Bitmap>(){

            @Override
            protected Bitmap doInBackground(String... strings) {
                Bitmap b = null;
                try {
                    URL url = new URL(strings[0]);
                    InputStream inputStream = url.openStream();
                    b = android.graphics.BitmapFactory.decodeStream(inputStream);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return b;
            }

            @Override
            protected void onPostExecute(Bitmap b){
                ivmenu.setImageBitmap(b);
            }

        }.execute(data.get(0).image_url);


//        try {
//            //Log.v("error",recipeData.get(1).image_url);
//            URL url = new URL(data.get(0).image_url);
//            InputStream inputStream = url.openStream();
//            Bitmap b = android.graphics.BitmapFactory.decodeStream(inputStream);
//            ivmenu.setImageBitmap(b);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e){
//            e.printStackTrace();
//        }
        tvmenu.setText(data.get(0).title);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NecesaryListDialog dialog = new NecesaryListDialog();
                dialog.show(getFragmentManager(), "dialog");
            }
        });
    }


}
