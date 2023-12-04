package com.ilyap.yuta.ui.fragments;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.ilyap.yuta.R;
import com.ilyap.yuta.utils.RequestViewModel;

public class ReadonlyProfileFragment extends ProfileFragment {
    private int userId;

    public ReadonlyProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_profile, container, false);


        if (getArguments() != null) {
            userId = getArguments().getInt("userId", -1);
        }


        progressLayout = view.findViewById(R.id.progressLayout);

        viewModel = new ViewModelProvider(this).get(RequestViewModel.class);
        updateProfile(userId);

        view.findViewById(R.id.log_out).setVisibility(GONE);
        view.findViewById(R.id.reload).setVisibility(GONE);
        view.findViewById(R.id.edit).setVisibility(GONE);

        View backButton = view.findViewById(R.id.back_button);
        backButton.setVisibility(VISIBLE);
        backButton.setOnClickListener(v -> handleBackPressed());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                handleBackPressed();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);
    }

    private void handleBackPressed() {
        getParentFragmentManager().popBackStack();
    }
}