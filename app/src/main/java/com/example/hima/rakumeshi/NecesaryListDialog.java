package com.example.hima.rakumeshi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DialerFilter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by hima on 14/09/01.
 */
public class NecesaryListDialog extends DialogFragment {

    private ListView listView;
    private ImageButton ok, cancel;
    private TextView title;

    @Override
    public Dialog onCreateDialog(Bundle bundle){


        Dialog dialog = super.onCreateDialog(bundle);

        dialog.setCanceledOnTouchOutside(false);

        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup group, Bundle b){

        View view = inflater.inflate(R.layout.necessary_list_dialog, null);
        listView = (ListView)view.findViewById(R.id.list_view);
        ok = (ImageButton)view.findViewById(R.id.ok);
        cancel = (ImageButton)view.findViewById(R.id.cancel);
        title = (TextView)view.findViewById(R.id.necessary);

        return  view;
    }
}
