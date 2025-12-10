package com.example.myspendyapp.ui.forgotpassword;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myspendyapp.R;
import com.example.myspendyapp.databinding.FragmentEnterEmailBinding;

public class FragmentEnterEmail extends Fragment {

    private FragmentEnterEmailBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Khởi tạo Binding
        binding = FragmentEnterEmailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnConfirm.setOnClickListener(v -> {
            String email = binding.edtEmail.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(getContext(), "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
                return;
            }

            // Tạo Bundle để truyền email sang màn hình OTP
            Bundle bundle = new Bundle();
            bundle.putString("email", email);

            // Chuyển hướng sang màn hình OTP
            // LƯU Ý: ID action này phải khớp với nav_graph bên dưới
            try {
                Navigation.findNavController(view).navigate(R.id.action_fragmentEnterEmail_to_fragmentEnterOtp, bundle);
            } catch (Exception e) {
                // Log lỗi nếu ID action bị sai
                e.printStackTrace();
                Toast.makeText(getContext(), "Lỗi chuyển hướng: Kiểm tra lại Navigation Graph", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
