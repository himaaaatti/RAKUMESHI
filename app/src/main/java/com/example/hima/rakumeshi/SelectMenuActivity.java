package com.example.hima.rakumeshi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        beef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SelectSecondMenuActivity.class);
                startActivity(intent);
            }
        });

        fish = (ImageButton)findViewById(R.id.fish_btn);

    }
}
