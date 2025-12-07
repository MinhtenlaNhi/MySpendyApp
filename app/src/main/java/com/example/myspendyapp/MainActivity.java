package com.example.myspendyapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        FloatingActionButton fabHome = findViewById(R.id.fab_home);

        // TextView label "Trang chủ" nếu bạn có thêm id cho nó thì findViewById ở đây để ẩn/hiện cùng FAB

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        // Tắt menu mặc định của item giữa (placeholder) để không bấm được
        navView.getMenu().findItem(R.id.navigation_home_placeholder).setEnabled(false);

        NavigationUI.setupWithNavController(navView, navController);

        // Xử lý sự kiện bấm nút Home tròn to
        fabHome.setOnClickListener(v -> {
            navController.navigate(R.id.navigation_home);
        });

        // Logic Ẩn/Hiện Menu và Nút Home
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            int id = destination.getId();

            if (id == R.id.navigation_login || id == R.id.navigation_register) {
                // Ẩn menu và nút Home ở màn hình đăng nhập/đăng ký
                navView.setVisibility(View.GONE);
                fabHome.setVisibility(View.GONE);
            } else {
                // Hiện menu và nút Home ở các màn hình chính
                navView.setVisibility(View.VISIBLE);
                fabHome.setVisibility(View.VISIBLE);
            }
        });
    }
}
