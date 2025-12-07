package com.example.myspendyapp;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
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

        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_activity_main);

        NavController navController = navHostFragment.getNavController();

        // Đưa người dùng vào LOGIN ngay khi mở app
        navController.navigate(R.id.navigation_login);

        // Định nghĩa các tab top-level (không có nút Back)
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_spending,
                R.id.navigation_notifications,
                R.id.navigation_account
        ).build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Ẩn / hiện BottomNav + ActionBar theo từng màn hình
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {

            // Danh sách các màn hình không cần bottom nav
            boolean isAuthScreen =
                    destination.getId() == R.id.navigation_login ||
                            destination.getId() == R.id.navigation_register ||
                            destination.getId() == R.id.navigation_enter_email ||
                            destination.getId() == R.id.navigation_reset_password;

            if (isAuthScreen) {
                binding.navView.setVisibility(View.GONE);

                if (getSupportActionBar() != null) {
                    getSupportActionBar().hide();
                }

            } else {
                binding.navView.setVisibility(View.VISIBLE);

                if (getSupportActionBar() != null) {
                    getSupportActionBar().show();
                }
            }
        });
    }

    // Xử lý nút Back trên ActionBar
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        return navController.navigateUp() || super.onSupportNavigateUp();
    }
}

