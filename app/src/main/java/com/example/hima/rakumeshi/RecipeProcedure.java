package com.example.hima.rakumeshi;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by masato on 9/8/14.
 */
public class RecipeProcedure  extends AsyncTask<Void, Void, String[]> {

    private String[] recipes;
    private String url;

    RecipeProcedure(String url) {
        this.url = url;
    }

    @Override
    protected String[] doInBackground(Void ... Void) {

        try {
            Document document = Jsoup.connect(url).get();
            String doc = document.text();

            recipes = getRecipes(doc);
            recipes[0] = getMaterial(doc);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return recipes;
    }

    private String[] getRecipes (String doc) {

        String startTarget = "作り方 1";
        String endTarget = "きっかけ";
        int start = doc.indexOf(startTarget);
        int end = doc.indexOf(endTarget);
        String recipe = doc.substring(start + "作り方".length(), end);

        recipes = recipe.split("\\d ");

        return recipes;
    }

    private String getMaterial (String doc) {

        String startTarget = "材料";
        String endTarget = "作り方 1";

        int start = doc.indexOf(startTarget);
        int end = doc.indexOf(endTarget);

        String material = doc.substring(start, end);
        String[] materialArray = material.split(" ");

        String materialStr = materialArray[0] + "\n";

        for (int i = 2; i < materialArray.length; i+=2) {
            materialStr += materialArray[i - 1] + " " + materialArray[i - 0] + "\n";
        }

        return materialStr;
    }
}
