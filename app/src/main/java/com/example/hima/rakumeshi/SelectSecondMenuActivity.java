package com.example.hima.rakumeshi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;

import java.nio.InvalidMarkException;

/**
 * Created by hima on 14/09/01.
 */
public class SelectSecondMenuActivity extends Activity {

    private ImageButton chicken, pork, beef;

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.select_second_menu_activity);


        chicken = (ImageButton)findViewById(R.id.chicken_btn);

        pork = (ImageButton)findViewById(R.id.pork_btn);

        beef = (ImageButton)findViewById(R.id.beef_btn);
    }
}

