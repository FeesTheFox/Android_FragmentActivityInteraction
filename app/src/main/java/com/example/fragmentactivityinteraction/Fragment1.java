package com.example.fragmentactivityinteraction;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragmentactivityinteraction.databinding.Fragment1Binding;

public class Fragment1 extends Fragment {
    final String LOG_TAG = "myLogs";
    private Fragment1Binding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding = Fragment1Binding.inflate(inflater,container,false);
       View view = binding.getRoot();
       binding.button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ((Button)getActivity().findViewById(R.id.btnFind)).setText("Access from Fragment 1");
           }
       });
       return view;

    }



}