package com.example.hima.rakumeshi;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by masato on 9/1/14.
 */
public class RecipeListFragment extends ListFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recipe_card_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(getArguments() != null && getArguments().containsKey("recipeData")) {
            String[] recipeData = getArguments().getStringArray("recipeData");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity()
                    , R.layout.recipe_item_layout, R.id.text1, recipeData);
            setListAdapter(adapter);
        }

    }

}
