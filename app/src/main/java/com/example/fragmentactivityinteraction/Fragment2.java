package com.example.fragmentactivityinteraction;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentactivityinteraction.databinding.Fragment2Binding;

public class Fragment2 extends Fragment {
    public interface onSomeEventListener{
        public void someEvent(String s);
    }

    onSomeEventListener someEventListener;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            someEventListener = (onSomeEventListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString() +
                    " must implement on-SomeEventListener");
        }
    }

    final String LOG_TAG = "myLogs";
    private Fragment2Binding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Fragment2Binding.inflate(inflater,container,false);
        View view = binding.getRoot();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                someEventListener.someEvent("Test text to Fragment1");
            }
        });
        return view;
    }
}