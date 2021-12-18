package com.example.labo1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFragment extends Fragment {

    MyFragment() {
        super(R.layout.fragment_main);
    }

    EditText editText;

    @SuppressLint("SimpleDateFormat")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.editText);
        view.findViewById(R.id.nextScreen).setOnClickListener(v -> {
            if (MainActivity.openFragment) {
                ((MyFragmentI) getActivity()).openFragment(editText.getText().toString());
            } else {
                ((MyFragmentI) getActivity()).openActivity(editText.getText().toString());
            }
        });
        view.findViewById(R.id.time_).setOnClickListener(v ->
                ((TextView) view.findViewById(R.id.textView))
                        .setText(new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date())));
    }
}
