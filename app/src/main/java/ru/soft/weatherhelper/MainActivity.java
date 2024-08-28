package ru.soft.weatherhelper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ru.soft.weatherhelper.model.CityService;

public class MainActivity extends AppCompatActivity {
    public static final String CHOSEN_CITY_TAG = "CHOSEN_CITY_TAG";

    private final CityService cityService = CityService.getSingleton();

    private ListView listView;
    private Button chooseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.citiesList);
//        listView.addItems(cityService.getCities());
        listView.setOnItemClickListener((parent, view, position, id) -> parent.getItemAtPosition(position));

        chooseButton = findViewById(R.id.chooseButton);
        chooseButton.setOnClickListener(v -> {
            createCircularReveal();
            Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
            intent.putExtra(WeatherActivity.CITY_TAG, getSelectedCityId());
            startActivity(intent);
        });

        TextView textView = findViewById(R.id.api_version_text);
        textView.setText("API version: " + Build.VERSION.SDK_INT);
    }

    private long getSelectedCityId() {
        long selectedItemId = listView.getSelectedItemId();
        Log.i(MainActivity.class.getName(), String.valueOf(selectedItemId));
        return selectedItemId;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CHOSEN_CITY_TAG, listView.getSelectedItemPosition());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(MainActivity.class.getName(), String.valueOf(savedInstanceState.getInt(CHOSEN_CITY_TAG)));
        listView.setSelection(savedInstanceState.getInt(CHOSEN_CITY_TAG));
    }

    private void createCircularReveal() {
        int cx = chooseButton.getWidth() / 2;
        int cy = chooseButton.getHeight() / 2;
        float radius = chooseButton.getWidth();
        Animator anim = ViewAnimationUtils
                .createCircularReveal(chooseButton, cx, cy, radius, 0);
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                chooseButton.setVisibility(View.INVISIBLE);
            }
        });
        anim.start();
    }
}