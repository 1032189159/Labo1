package com.example.labo1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ShareTextFragment extends Fragment {

    ShareTextFragment() {
        super(R.layout.activity_my);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((TextView) view.findViewById(R.id.textShare)).setText(getArguments().getString(MainActivity.text));
    }
}
