package com.example.myspendyapp;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myspendyapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Định nghĩa các màn hình cấp cao nhất (không có nút Back)
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_spending,
                R.id.navigation_notifications, R.id.navigation_account)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // === LOGIC ẨN/HIỆN BOTTOM NAVIGATION ===
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            // Kiểm tra ID của màn hình đích
            if (destination.getId() == R.id.navigation_login || destination.getId() == R.id.navigation_register) {
                binding.navView.setVisibility(View.GONE); // Ẩn BottomNav
                getSupportActionBar().hide(); // Ẩn ActionBar
            } else {
                binding.navView.setVisibility(View.VISIBLE); // Hiện BottomNav
                getSupportActionBar().show(); // Hiện ActionBar
            }
        });
    }
}
