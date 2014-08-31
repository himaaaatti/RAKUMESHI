package com.example.hima.rakumeshi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends Activity {


    private ImageButton menu, pay;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        menu = (ImageButton)findViewById(R.id.menu_btn);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SelectMenuActivity.class);
                startActivity(intent);
            }
        });

        pay = (ImageButton)findViewById(R.id.pay_btn);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PayListActivity.class);
                startActivity(intent);
            }
        });


    }
}
