package com.ottoboni.interview.fragments;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ottoboni.interview.R;

/**
 * Created by caoj on 28/03/18.
 */

public class ButtonsFragment extends Fragment {
    
    private Button mToastButton;
    private Button mAlertButton;
    
    public ButtonsFragment() {}

    public static ButtonsFragment newInstance() {
        ButtonsFragment fragment = new ButtonsFragment();
        
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_buttons, container, false);
        
        initLayout(rootView);
        
        return rootView;
    }
    
    private View.OnClickListener mButtonsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.toast_button:
                    Toast.makeText(getContext(), "This is a Toast!!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.alert_button:
                    AlertDialog.Builder builder;

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Dialog_Alert);
                    } else {
                        builder = new AlertDialog.Builder(getContext());
                    }

                    builder.setTitle("This is a Dialog!")
                            .setMessage("This is the Dialog body")
                            .show();
                    break;
                default:
                    Log.e("error_id", "Id not found!!");
            }
        }
    };
    
    private void initLayout(View view) {
        
        mToastButton = (Button) view.findViewById(R.id.toast_button);
        mAlertButton = (Button) view.findViewById(R.id.alert_button);

        mToastButton.setOnClickListener(mButtonsClickListener);
        mAlertButton.setOnClickListener(mButtonsClickListener);
        
        
    }
}
