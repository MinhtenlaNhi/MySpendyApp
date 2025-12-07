package com.example.myspendyapp.ui.forgotpassword;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myspendyapp.R;

public class FragmentResetPassword extends Fragment {

    private EditText edtPassword, edtRePassword;
    private Button btnReset;
    private String email;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_reset_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtPassword = view.findViewById(R.id.edtPassword);
        edtRePassword = view.findViewById(R.id.edtRePassword);
        btnReset = view.findViewById(R.id.btnReset);

        if (getArguments() != null) {
            email = getArguments().getString("email");
        }

        btnReset.setOnClickListener(v -> {
            String pass = edtPassword.getText().toString().trim();
            String confirm = edtRePassword.getText().toString().trim();

            if (TextUtils.isEmpty(pass) || TextUtils.isEmpty(confirm)) {
                Toast.makeText(getContext(), "Vui lòng nhập đầy đủ", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!pass.equals(confirm)) {
                Toast.makeText(getContext(), "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                return;
            }

            // TODO: call API reset password tại đây

            Toast.makeText(getContext(), "Đặt lại mật khẩu thành công!", Toast.LENGTH_SHORT).show();

            // Có thể popBackStack về màn Đăng nhập
            getActivity().onBackPressed();
        });
    }
}

