package com.example.imageslider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    private TextView cityName;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RadioGroup radioGroup;

    private ArrayList<City> cities;
    private ViewPagerAdapter adapter;

    private City selectedCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        cities = new ArrayList<>();
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        initCities();
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);




        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                cityChanged(i);

            }
        });
    }



    private void cityChanged(int rbID)
    {
        Log.d(TAG, "cityChanged: Started");
        switch (rbID)
        {
            case R.id.rbLondon:
                selectedCity = getCityByName("London");
                break;
            case R.id.rbDhaka:
                selectedCity = getCityByName("Dhaka");
                break;
            case R.id.rbTokyo:
                selectedCity = getCityByName("Tokyo");
                break;
            case R.id.rbWashington:
                selectedCity = getCityByName("Washington");
                break;
            default:
                break;
        }

        if(null != selectedCity)
        {
            cityName.setText(selectedCity.getName());

            ArrayList<ImageFragment> fragments = new ArrayList<>();

            for (int i = 0; i <selectedCity.getImageUrls().size() ; i++) {
                ImageFragment imageFragment = new ImageFragment();
                Bundle bundle = new Bundle();
                bundle.putString("imageUrl", selectedCity.getImageUrls().get(i));
                imageFragment.setArguments(bundle);
                fragments.add(imageFragment);
            }

            adapter.setFragments(fragments);
        }
    }

    private City getCityByName(String name)
    {
        Log.d(TAG, "getCityByName: Started");

        for (City c:cities)
        {
            if (c.getName().equals(name))
            return c;

        }
        return null;
    }


    private void initViews()
    {
        Log.d(TAG, "initViews: started");

        cityName = (TextView) findViewById(R.id.txtCityName);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.citiesViewPager);
        radioGroup = (RadioGroup) findViewById(R.id.rgCities);
    }

    private void initCities()
    {

        City london = new City();
        london.setName("London");
        ArrayList<String> londonImageUrls = new ArrayList<>();
        londonImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/8/86/City_of_London%2C_seen_from_Tower_Bridge.jpg/375px-City_of_London%2C_seen_from_Tower_Bridge.jpg");
        londonImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Guildhall%2C_Londres%2C_Inglaterra%2C_2014-08-11%2C_DD_139.JPG/330px-Guildhall%2C_Londres%2C_Inglaterra%2C_2014-08-11%2C_DD_139.JPG");
        londonImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Leadenhall_Market_In_London_-_Feb_2006.jpg/330px-Leadenhall_Market_In_London_-_Feb_2006.jpg");
        londonImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Finsbury_Circus.jpg/330px-Finsbury_Circus.jpg");
        london.setImageUrls(londonImageUrls);

        City dhaka = new City();
        dhaka.setName("Dhaka");
        ArrayList<String> dhakaImageUrls = new ArrayList<>();
        dhakaImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Dhaka_lights.jpg/390px-Dhaka_lights.jpg");
        dhakaImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7c/Recreational_value_of_Hatirjheel.jpg/194px-Recreational_value_of_Hatirjheel.jpg");
        dhakaImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/National_Assembly_%2825967498804%29.jpg/194px-National_Assembly_%2825967498804%29.jpg");
        dhakaImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Diwan-i-Am_and_Tomb_of_Pari_Bibi_with_Garden_-_North-western_View_-_Lalbagh_Fort_Complex_-_Dhaka_2015-05-31_2715.JPG/194px-Diwan-i-Am_and_Tomb_of_Pari_Bibi_with_Garden_-_North-western_View_-_Lalbagh_Fort_Complex_-_Dhaka_2015-05-31_2715.JPG");
        dhaka.setImageUrls(dhakaImageUrls);

        City tokyo = new City();
        tokyo.setName("Tokyo");
        ArrayList<String> tokyoImageUrls = new ArrayList<>();
        tokyoImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Tokyo_Montage_2015.jpg/405px-Tokyo_Montage_2015.jpg");
        tokyoImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Tokyo_Montage_2015.jpg/405px-Tokyo_Montage_2015.jpg");
        tokyoImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bf/Tokyo_Montage_2015.jpg/405px-Tokyo_Montage_2015.jpg");
        tokyoImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Tokyo-edohakub-ginza.jpg/389px-Tokyo-edohakub-ginza.jpg");
        tokyo.setImageUrls(tokyoImageUrls);

        City washington = new City();
        washington.setName("Washington");
        ArrayList<String> washingtonImageUrls = new ArrayList<>();
        washingtonImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Washington_Montage_2016.png/375px-Washington_Montage_2016.png");
        washingtonImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Washington_Montage_2016.png/375px-Washington_Montage_2016.png");
        washingtonImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Washington_Montage_2016.png/375px-Washington_Montage_2016.png");
        washingtonImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Washington_Montage_2016.png/375px-Washington_Montage_2016.png");
        washington.setImageUrls(washingtonImageUrls);

        cities.add(london);
        cities.add(dhaka);
        cities.add(tokyo);
        cities.add(washington);
    }

}