package com.example.labo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Pair;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements MyFragmentI {

    // переключатель относительно требуемого условия задания (открыть активность или фрагмент)
    public static boolean openFragment = true;
    public static String text = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new MyFragment());
    }

    void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null).commit();
    }

    @Override
    public void openActivity(String str) {
        startActivity(new Intent(getApplicationContext(), MyActivity.class).putExtra(text, str));
    }

    @Override
    public void openFragment(String str) {
        Fragment fragment = new ShareTextFragment();
        Bundle b = new Bundle();
        b.putString(text, str);
        fragment.setArguments(b);
        replaceFragment(fragment);
    }
}