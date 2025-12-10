package com.example.myspendyapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myspendyapp.R;
import com.example.myspendyapp.databinding.FragmentLoginBinding;
// import com.example.myspendyapp.repository.UserRepository; // Bỏ comment nếu bạn đã có class này

public class FragmentLogin extends Fragment {

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        // --- XỬ LÝ ĐĂNG NHẬP ---
        binding.btnLogin.setOnClickListener(v -> {
            String user = binding.edtUsername.getText().toString().trim();
            String pass = binding.edtPassword.getText().toString().trim();

            // Giả lập check login (Bạn thay bằng code UserRepository của bạn)
            if (!user.isEmpty() && !pass.isEmpty()) {
                // ID này khớp với dòng 17 trong mobile_navigation.xml
                navController.navigate(R.id.action_login_to_home);
            } else {
                Toast.makeText(getContext(), "Vui lòng nhập tài khoản/mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        // --- XỬ LÝ QUÊN MẬT KHẨU ---
        binding.forgotPassword.setOnClickListener(v -> {
            // SỬA LỖI Ở ĐÂY: ID này phải khớp dòng 27 trong mobile_navigation.xml
            try {
                navController.navigate(R.id.action_loginFragment_to_forgotPasswordFragment);
            } catch (Exception e) {
                e.printStackTrace(); // In lỗi ra Logcat nếu crash
            }
        });

        // --- XỬ LÝ ĐĂNG KÝ ---
        binding.txtRegister.setOnClickListener(v -> {
            // ID này khớp với dòng 22 trong mobile_navigation.xml
            navController.navigate(R.id.action_login_to_register);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
