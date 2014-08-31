package com.example.hima.rakumeshi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        final Intent intent = new Intent(getApplicationContext(), DecideMenu.class);

        chicken = (ImageButton)findViewById(R.id.chicken_btn);
        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("categoryType", "10-278");
                startActivity(intent);
            }
        });

        pork = (ImageButton)findViewById(R.id.pork_btn);
        pork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("categoryType", "10-276");
                startActivity(intent);
            }
        });

        beef = (ImageButton)findViewById(R.id.beef_btn);
        beef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("categoryType", "10-275");
                startActivity(intent);
            }
        });
    }
}

