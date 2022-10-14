package com.khalid.go4lunch.ui.restaurant_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.khalid.go4lunch.R;
import com.khalid.go4lunch.databinding.ActivityListRestaurantBinding;

public class ListRestaurantActivity extends AppCompatActivity {

    private ActivityListRestaurantBinding binding;
    private RestaurantFragment mRestaurantFragment = new RestaurantFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurant);

        binding = ActivityListRestaurantBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //setSupportActionBar(binding.appbar);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view, mRestaurantFragment)
                    .commit();
        }

    }

}