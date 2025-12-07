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


public class FragmentEnterEmail extends Fragment {

    private EditText edtEmail;
    private Button btnConfirm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_enter_email, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        edtEmail = view.findViewById(R.id.edtEmail);
        btnConfirm = view.findViewById(R.id.btnConfirm);

        btnConfirm.setOnClickListener(v -> {
            String email = edtEmail.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getContext(), "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
                return;
            }

            // TODO: call API gửi OTP vào email ở đây

            // Chuyển sang màn hình nhập OTP
            Bundle bundle = new Bundle();
            bundle.putString("email", email);

            Navigation.findNavController(view)
                    .navigate(R.id.action_enter_email_to_enter_otp, bundle);
        });
    }
}
