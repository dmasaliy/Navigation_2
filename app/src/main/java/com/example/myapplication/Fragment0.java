package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment0 extends Fragment {

    Button next;
    Button back;
    TextView textView;

    Fragment0ClickListener listener;

    String strArg;
    int intArg;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (Fragment0.Fragment0ClickListener) context;
        } catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        strArg = getArguments().getString(MainActivity.BUNDLE_STRING, "");
//        intArg = getArguments().getInt(getResources().getString(R.string.argument_one));
//        Fragment2Args fragment2Args = Fragment2Args.fromBundle(getArguments());
//        intArg = fragment2Args.getStringArgumentOne();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_0, container, false);

        next = view.findViewById(R.id.next0);
        back = view.findViewById(R.id.back0);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFragment0NextClick();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onFragment0BackClick();
            }
        });

        textView = view.findViewById(R.id.textView0);
//        textView.setText(intArg + "");

        return view;
    }

    public interface Fragment0ClickListener {
        void onFragment0NextClick();
        void onFragment0BackClick();
    }
}