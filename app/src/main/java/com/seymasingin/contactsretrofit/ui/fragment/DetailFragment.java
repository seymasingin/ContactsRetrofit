package com.seymasingin.contactsretrofit.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seymasingin.contactsretrofit.R;
import com.seymasingin.contactsretrofit.data.model.Person;
import com.seymasingin.contactsretrofit.databinding.FragmentDetailBinding;
import com.seymasingin.contactsretrofit.ui.viewmodel.DetailViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailFragment extends Fragment {
    private FragmentDetailBinding binding;
    private DetailViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDetailBinding.inflate(inflater, container, false);

        binding.toolbarDetail.setTitle("Detail");

        DetailFragmentArgs bundle = DetailFragmentArgs.fromBundle(getArguments());
        Person person = bundle.getPerson();

        binding.etName.setText(person.getPerson_name());
        binding.etTel.setText(person.getPerson_tel());
        binding.buttonRefresh.setOnClickListener(view -> {
            String etName = binding.etName.getText().toString();
            String etTel = binding.etTel.getText().toString();
            refresh(person.getPerson_id(), etName, etTel);
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DetailViewModel.class);
    }

    public void refresh(int person_id, String person_name, String person_tel) {
        viewModel.refresh(person_id,person_name,person_tel);
    }
}