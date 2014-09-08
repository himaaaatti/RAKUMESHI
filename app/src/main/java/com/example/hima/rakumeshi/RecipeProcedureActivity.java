package com.example.hima.rakumeshi;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by masato on 9/3/14.
 */
public class RecipeProcedureActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.recipe_fragment);

        Intent intent = getIntent();

        String[] data = (String[])intent.getSerializableExtra("recipeData");


        FragmentManager manager = getFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        Fragment fragment = new RecipeListFragment();

        //recipedata
        Bundle bundle = new Bundle();
        bundle.putStringArray("recipeData", data);

        fragment.setArguments(bundle);

        transaction.add(R.id.fragment_container, fragment );

        transaction.commit();

    }

}
