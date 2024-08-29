package ru.soft.weatherhelper;

import static android.widget.AbsListView.CHOICE_MODE_SINGLE;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import ru.soft.weatherhelper.modelView.CityListViewModel;


public class ChooseCityFragment extends Fragment {
    private static final String SELECTED_TAG = "ChooseCityFragment.SELECTED";

    private CityListViewModel cityListViewModel;

    private ListView listView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(ChooseCityFragment.class.getName(), "onCreate: " + savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_city, container, false);

        cityListViewModel = ViewModelProviders.of(this).get(CityListViewModel.class);
        listView = view.findViewById(R.id.citiesList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.list_item, cityListViewModel.getCities());
        listView.setAdapter(adapter);
        if (savedInstanceState != null) {
            listView.setSelection(savedInstanceState.getInt(SELECTED_TAG));
        }

        Log.i(ChooseCityFragment.class.getName(), "onCreateView: " + savedInstanceState);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(getActivity(), WeatherActivity.class);
            intent.putExtra(WeatherActivity.CITY_TAG, (String)listView.getItemAtPosition(position));
            getActivity().startActivityForResult(intent, 0);
        });
        Log.i(ChooseCityFragment.class.getName(), "onStart");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(MainActivity.class.getName(), "Request code: " + requestCode);
        Log.i(MainActivity.class.getName(), "Result code: " + resultCode);
        Log.i(MainActivity.class.getName(), "Intent data: " + data);

    }
}