package com.example.myspendyapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.myspendyapp.R;
import com.example.myspendyapp.databinding.FragmentAccountBinding;
import com.example.myspendyapp.databinding.RowAccountItemBinding;

public class FragmentAccount extends Fragment {

    private FragmentAccountBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAccountBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        // Thiết lập từng item
        setupItem(binding.btnChangeInfo.getRoot(), R.drawable.ic_person, "Thay đổi thông tin cá nhân");
        setupItem(binding.btnChangePassword.getRoot(), R.drawable.ic_lock_blue, "Thay đổi mật khẩu");
        setupItem(binding.btnSetting.getRoot(), R.drawable.ic_setting, "Cài đặt");
        setupItem(binding.btnAppInfo.getRoot(), R.drawable.ic_info, "Thông tin ứng dụng");
        setupItem(binding.btnSupport.getRoot(), R.drawable.ic_support, "Hỗ trợ");
    }
    //Thêm code xử lý chuyển sang các màn thay đổi thông tin, thay đổi mật khẩu, cài đặt...




    /*Setup icon + title cho 1 item */
    private void setupItem(View item, int iconRes, String title) {
        ImageView icon = item.findViewById(R.id.icon);
        TextView titleView = item.findViewById(R.id.title);

        icon.setImageResource(iconRes);
        titleView.setText(title);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
