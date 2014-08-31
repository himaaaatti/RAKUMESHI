package com.example.hima.rakumeshi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by hima on 14/08/31.
 */
public class PayListActivity extends Activity {

    private ListView listView;

    @Override
    public void onCreate(Bundle bundle){

        super.onCreate(bundle);
        setContentView(R.layout.pay_list_activity);

        listView = (ListView)findViewById(R.id.list_view);
    }

}
