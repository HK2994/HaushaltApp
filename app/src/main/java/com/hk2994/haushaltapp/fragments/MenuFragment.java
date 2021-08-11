package com.hk2994.haushaltapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.hk2994.haushaltapp.R;

import org.jetbrains.annotations.NotNull;


public class MenuFragment extends Fragment {

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);

        ImageButton navBudgetBttn = view.findViewById(R.id.navBudgetButton);
        ImageButton navToDoBttn = view.findViewById(R.id.navToDoListButton);
        ImageButton navStorageBttn = view.findViewById(R.id.navStorageButton);
        ImageButton navSettingsBttn = view.findViewById(R.id.navSettingsButton);

        navBudgetBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_menuFragment_to_balanceFragment);
            }
        });

        navToDoBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_menuFragment_to_toDoListFragment);
            }
        });

        navStorageBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_menuFragment_to_storageFragment);
            }
        });

        navSettingsBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_menuFragment_to_settingsFragment);
            }
        });

    }
}