package com.wilsonrc.bairesdevtest.UI;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.wilsonrc.bairesdevtest.R;
import com.google.android.gms.plus.PlusOneButton;

/**
 * A fragment with a Google +1 button.
 * Use the {@link TwoButtonsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TwoButtonsFragment extends Fragment {

    private Button mShowToast;
    private Button mShowAlert;


    public TwoButtonsFragment() {
        // Required empty public constructor
    }


    public static TwoButtonsFragment newInstance() {
        TwoButtonsFragment fragment = new TwoButtonsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two_buttons, container, false);

        mShowToast =  view.findViewById(R.id.buttonShowToast);
        mShowAlert =  view.findViewById(R.id.buttonShowAlert);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       mShowToast.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view) {
               Toast.makeText(getContext(), R.string.toast_this_is_toast_message, Toast.LENGTH_LONG).show();
           }
       });

        mShowAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                alertDialog.setTitle("This is the dialog title");
                alertDialog.setMessage("This is the body of the dialog");
                alertDialog.create();
                alertDialog.show();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();


    }


}
