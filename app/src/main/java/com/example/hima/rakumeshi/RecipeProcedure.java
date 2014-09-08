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
            String startTarget = "作り方 1";
            String endTarget = "きっかけ";
            int start = doc.indexOf(startTarget);
            int end = doc.indexOf(endTarget);
            String recipe = doc.substring(start + "作り方".length(), end);

            recipes = recipe.split("\\d ");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return recipes;
    }

}
