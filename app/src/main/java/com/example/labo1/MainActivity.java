package com.example.labo1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MyFragmentI {

    // переключатель относительно требуемого условия задания (открыть активность или фрагмент)
    public static boolean openFragment = false;
    public static String text = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new MyFragment())
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
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null).commit();
    }
}