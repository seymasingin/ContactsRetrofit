package com.seymasingin.contactsretrofit.ui.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.seymasingin.contactsretrofit.R;
import com.seymasingin.contactsretrofit.databinding.FragmentHomeBinding;
import com.seymasingin.contactsretrofit.ui.adapter.PersonAdapter;
import com.seymasingin.contactsretrofit.ui.viewmodel.HomeViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment implements SearchView.OnQueryTextListener, PersonAdapter.ContactsListener{

    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        binding.toolbarHome.setTitle("Home");
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbarHome);

        viewModel.personList.observe(getViewLifecycleOwner(), liste -> {
            PersonAdapter adapter = new PersonAdapter(liste, this);
            binding.rv.setAdapter(adapter);
        });

        binding.fab.setOnClickListener(view ->{
            Navigation.findNavController(view).navigate(R.id.homeToAdd);
        });

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu);

                MenuItem item = menu.findItem(R.id.action_search);
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener(HomeFragment.this);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.search(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        viewModel.search(newText);
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.getContacts();
    }

    @Override
    public void onDelete(int person_id) {
        viewModel.delete(person_id);
    }
}