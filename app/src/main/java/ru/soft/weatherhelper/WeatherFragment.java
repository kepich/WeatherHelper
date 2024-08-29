package ru.soft.weatherhelper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WeatherFragment extends Fragment {

    private static final String SKY_ARG = "sky_param";
    private static final String RAIN_ARG = "rain_param";

    private String sky;
    private boolean isRain;

    public WeatherFragment() {
        // Required empty public constructor
    }

    public static WeatherFragment newInstance(String sky, boolean isRain) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString(SKY_ARG, sky);
        args.putBoolean(RAIN_ARG, isRain);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            sky = getArguments().getString(SKY_ARG);
            isRain = getArguments().getBoolean(RAIN_ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);

        TextView skyTextView = view.findViewById(R.id.skyTextView);
        skyTextView.setText(sky);

        TextView rainTextView = view.findViewById(R.id.rainTextView);
        rainTextView.setText(String.valueOf(isRain));

        return view;
    }
}