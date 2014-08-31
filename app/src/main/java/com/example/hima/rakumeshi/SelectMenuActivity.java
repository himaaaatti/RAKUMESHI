package com.example.hima.rakumeshi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by hima on 14/08/31.
 */
public class SelectMenuActivity extends Activity {

    private ImageButton recomend, beef, fish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_menu_activity);

        recomend = (ImageButton)findViewById(R.id.recomend_btn);

        beef = (ImageButton)findViewById(R.id.beef_btn);

        fish = (ImageButton)findViewById(R.id.fish_btn);

    }
}
