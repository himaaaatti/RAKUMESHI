package com.example.hima.rakumeshi;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.android.volley.Response.*;

/**
 * Created by hima on 14/09/01.
 */
public class NetworkManager extends Volley {


    private RequestQueue requestQueue;
    private Context context;

    private Response.Listener<JSONObject> listener;
    private HashMap<String, String> params;
    private Cache cache;

    private ErrorListener errorListener = new ErrorListener(){

        @Override
        public void onErrorResponse(VolleyError volleyError) {
            Log.d("onErrorResponse", volleyError.toString());
        }
    };

    private String uri = "https://app.rakuten.co.jp/services/api/";
    private String application_id = "?applicationId=1099124229152739382";

//   api =  Recipe/CategoryRanking/20121121

    public NetworkManager(Context context){
        requestQueue = Volley.newRequestQueue(context);
        params = new HashMap<String, String>();
        requestQueue.start();
    }

    private void get(String api, Listener<JSONObject> listener) {
        String url = uri + api + application_id;
        for(Map.Entry<String, String> map: params.entrySet()){
            url += "&" + map.getKey() + "=" + map.getValue();
        }

        requestQueue.add(new JsonObjectRequest(Request.Method.GET, url, null, listener, errorListener));
        params.clear();

    }

    private void getCategoryData(Listener<JSONObject> listener){
        params.put("categoryType", "large");
        get("Recipe/CategoryList/20121121", listener);
    }

    public void getMainDish(Listener<JSONObject> listener){
        get("Recipe/CategoryRanking/20121121", listener);
    }

    public void setParam(String key, String value){
        params.put(key,value);
    }
}


