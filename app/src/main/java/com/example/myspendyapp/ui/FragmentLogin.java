package com.example.myspendyapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment; // Bắt buộc import thư viện này
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.myspendyapp.R;

public class FragmentLogin extends Fragment {

    public FragmentLogin() {

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
        final NavController navController = Navigation.findNavController(view);
        btnLogin.setOnClickListener(v -> {
            String user = edtUsername.getText().toString();
            String pass = edtPassword.getText().toString();
            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(getContext(), "Không được để trống!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.action_login_to_home);
            }
        });
    }
}
