package com.example.hima.rakumeshi;

import java.util.ArrayList;

/**
 * Created by hima on 14/09/01.
 */
public class RecipeData {

    private String url;
    private String image_url;
    private String title;
    private String nic_name;
    private String description;
    private ArrayList<String> material;
    private String indication;
    private String cost;
    int id;

    public RecipeData(String url, String image_url, String title, String nic_name, String description, String indication, String cost)
    {
        this.url = url;
        this.image_url = image_url;
        this.title = title;
        this.nic_name = nic_name;
        this.description = description;
        this.indication = indication;
        this.cost = cost;
    }



}
