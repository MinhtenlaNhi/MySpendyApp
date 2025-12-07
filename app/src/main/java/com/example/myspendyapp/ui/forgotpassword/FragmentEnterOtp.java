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
import androidx.navigation.Navigation;

import com.example.myspendyapp.R;

public class FragmentEnterOtp extends Fragment {

    private EditText edtOtp;
    private Button btnVerifyOtp;
    private String email;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_enter_otp, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtOtp = view.findViewById(R.id.edtOtp);
        btnVerifyOtp = view.findViewById(R.id.btnVerifyOtp);

        if (getArguments() != null) {
            email = getArguments().getString("email");
        }

        btnVerifyOtp.setOnClickListener(v -> {
            String otp = edtOtp.getText().toString().trim();

            if (TextUtils.isEmpty(otp)) {
                Toast.makeText(getContext(), "Vui lòng nhập OTP", Toast.LENGTH_SHORT).show();
                return;
            }

            // TODO: verify OTP with server

            Bundle bundle = new Bundle();
            bundle.putString("email", email);

            Navigation.findNavController(view)
                    .navigate(R.id.action_enter_otp_to_reset_password, bundle);
        });
    }
}

