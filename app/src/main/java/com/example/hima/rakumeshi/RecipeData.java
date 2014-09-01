package com.example.hima.rakumeshi;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by hima on 14/09/01.
 */
public class RecipeData implements Serializable{

    public String url;
    public  String image_url;
    public String title;
    private String nic_name;
    private String description;
    private ArrayList<String> material;
    private String indication;
    private String cost;
    int id;

    public RecipeData(String url, String image_url, String title, String nic_name, String description, String indication, String cost)
    {
        /*this.url = url;
        this.image_url = image_url;
        this.title = title;
        this.nic_name = nic_name;
        this.description = description;
        this.indication = indication;
<<<<<<< HEAD
        this.cost = cost;*/
=======
        this.cost = cost;

        material = new ArrayList<String>();
        processes = new ArrayList<String>();

//        Log.d("dbeug", url);
        new AsyncTask<String, Document, Document>(){

            @Override
            protected Document doInBackground(String... strings) {
                try {
                    return Jsoup.connect(strings[0]).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Document document){
                Elements els = document.body().children();
                Log.d("debug", els.toString());
                for(int i=0; i<els.size(); i++){
                    String tmp = els.get(i).select("p.stepMemo").toString();
                    if(tmp.length() != 0) {
                        processes.add(els.get(i).select("p.stepMemo").toString());


                        Log.d("debug", tmp);

                    }//                    Log.d("debug", String.valueOf(tmp.indexOf('>')));
                }
            }


        }.execute(url);
//        getProcess();
>>>>>>> d3b05eb5276f5d7df89029fd3bcab40003b32c8b
    }


//    private void getProcess(){
//
//            try {
//                Document doc = Jsoup.connect(url).get();
//                Log.d("debug", doc.toString());
//                Element element = doc.body();
//                Elements els = element.children();
//
//
//                for(int i=0; i <els.size();i++) {
//                    String tmp = els.get(i).select("p.stepMemo").toString();
//                    Log.d("debug", tmp);
//                    Log.d("debug", String.valueOf(tmp.indexOf('>')));
//                    processes.add(tmp);
//                }
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }



//   }




}
