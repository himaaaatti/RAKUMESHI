package com.example.hima.rakumeshi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


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

                String url = "http://recipe.rakuten.co.jp/recipe/1370004549/";

                RecipeProcedure recipeProcedure = new RecipeProcedure(url);
                recipeProcedure.execute();

                try {
                    String[] recipes = recipeProcedure.get();
                    //Log.d("recipe",recipes[1]);

                    Intent intent = new Intent(context, RecipeProcedureActivity.class);
                    intent.putExtra("recipeData", recipes);

                    startActivity(intent);

                } catch (Exception e) {

                }

            }
        });

    }
}
