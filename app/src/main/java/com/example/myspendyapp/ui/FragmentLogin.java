package com.example.myspendyapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myspendyapp.R;
import com.example.myspendyapp.repository.UserRepository;

public class FragmentLogin extends Fragment {

    public FragmentLogin() {
        //super (R.layout.fragment_login);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText edtUsername = view.findViewById(R.id.edtUsername);
        EditText edtPassword = view.findViewById(R.id.edtPassword);
        Button btnLogin = view.findViewById(R.id.btnLogin);
        TextView forgotPassword = view.findViewById(R.id.forgotPassword);
        TextView txtRegisterHere = view.findViewById(R.id.txtRegisterHere);

        NavController navController = Navigation.findNavController(view);

        UserRepository repo = new UserRepository(getContext());
        // Xử lý Login
        btnLogin.setOnClickListener(v -> {
            String user = edtUsername.getText().toString();
            String pass = edtPassword.getText().toString();

            if (repo.login(user, pass)) {
                navController.navigate(R.id.action_login_to_home);
            } else {
                Toast.makeText(getContext(), "Sai tài khoản hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
            }
        });

        // Xử lý Quên mật khẩu
        forgotPassword.setOnClickListener(v -> {
            navController.navigate(R.id.action_login_to_enter_email);
        });

        // Xử lý Đăng ký tại đây
        txtRegisterHere.setOnClickListener(v -> {
            navController.navigate(R.id.action_login_to_register);
        });
    }
}
