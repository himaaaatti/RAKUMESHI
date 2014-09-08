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

    public String[] getRecipeProcedure() {
        return recipes;
    }

    @Override
    protected String[] doInBackground(Void ... Void) {
        // httpリクエスト投げる処理を書く。
        // ちなみに私はHttpClientを使って書きましたー


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


    synchronized protected void onPostExecute(String[] recipes) {

        Log.d("recipessssss", recipes[1]);

    }

}
