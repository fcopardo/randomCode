package com.inigoflores.mymenuapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {

    View view;
    Button bt_message;
    Button bt_alert;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_button, container, false);
        bt_message = view.findViewById(R.id.bt_message);
        bt_alert = view.findViewById(R.id.bt_alert);

        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Hello my Message", Toast.LENGTH_SHORT).show();
            }
        });

        bt_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Hello: ","my message");
            }
        });

        return view;
    }

}
