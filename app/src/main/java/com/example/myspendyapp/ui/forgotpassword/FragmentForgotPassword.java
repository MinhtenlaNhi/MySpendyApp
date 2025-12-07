package com.example.myspendyapp.ui.forgotpassword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentForgotPassword extends Fragment {


    public void ForgotPasswordFragment() {
        // Required empty constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnResetPassword.setOnClickListener(v -> {
            String emailOrPhone = binding.edtEmailPhone.getText().toString().trim();

            if (emailOrPhone.isEmpty()) {
                Toast.makeText(getContext(), "Vui lòng nhập email hoặc số điện thoại", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Đã gửi yêu cầu đặt lại mật khẩu!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
