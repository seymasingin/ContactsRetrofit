package com.seymasingin.contactsretrofit.ui.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.seymasingin.contactsretrofit.databinding.FragmentAddBinding;
import com.seymasingin.contactsretrofit.ui.viewmodel.AddViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AddFragment extends Fragment {
    private FragmentAddBinding binding;
    private AddViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentAddBinding.inflate(inflater, container, false);

        binding.toolbarAdd.setTitle("Add");
        binding.buttonAdd.setOnClickListener(view -> {
            String etName = binding.etName.getText().toString();
            String etTel = binding.etTel.getText().toString();
            add(etName, etTel);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AddViewModel.class);
    }

    public void add(String etName, String etTel) {
        viewModel.add(etName,etTel);
    }
}