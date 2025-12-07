package com.example.myspendyapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myspendyapp.R;
import com.google.android.material.textfield.TextInputEditText;

public class FragmentLogin extends Fragment {
    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    private TextView txtRegister, forgotPassword;

    public FragmentLogin() {
        // Bắt buộc phải có constructor rỗng
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtUsername = view.findViewById(R.id.edtUsername);
        edtPassword = view.findViewById(R.id.edtPassword);

        View btnLogin = view.findViewById(R.id.btnLogin);
        View txtRegister = view.findViewById(R.id.txtRegister);
        View forgotPassword = view.findViewById(R.id.forgotPassword);

        // Xử lý nút Đăng nhập
        btnLogin.setOnClickListener(v -> {
            String username = edtUsername.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();

            if (username.isEmpty()) {
                Toast.makeText(getContext(), "Vui lòng nhập tên đăng nhập", Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.isEmpty()) {
                Toast.makeText(getContext(), "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                return;
            }

            // Login thành công → Điều hướng sang HomeFragment
            Navigation.findNavController(v).navigate(R.id.action_login_to_home);
        });

        // Điều hướng sang màn Register
        txtRegister.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_login_to_register)
        );

        // Điều hướng sang Forgot Password
        forgotPassword.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        );
    }
}

