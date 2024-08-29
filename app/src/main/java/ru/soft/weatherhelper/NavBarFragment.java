package ru.soft.weatherhelper;

import static ru.soft.weatherhelper.WeatherActivity.CITY_TAG;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class NavBarFragment extends Fragment {

    private static final String CITY_NAME_ARG = "city_name_param";

    // TODO: Rename and change types of parameters
    private String cityName;

    public static NavBarFragment newInstance(String cityName) {
        NavBarFragment fragment = new NavBarFragment();
        Bundle args = new Bundle();
        args.putString(CITY_NAME_ARG, cityName);
        fragment.setArguments(args);
        return fragment;
    }

    public NavBarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cityName = getArguments().getString(CITY_NAME_ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_bar, container, false);

        FloatingActionButton backButton = view.findViewById(R.id.backFloatingActionButton);
        backButton.setOnClickListener(onClickListener -> {
            Intent intent = new Intent();
            intent.putExtra(CITY_TAG, "Back");
            getActivity().setResult(5, intent);
            getActivity().finish();
        });

        return view;
    }
}