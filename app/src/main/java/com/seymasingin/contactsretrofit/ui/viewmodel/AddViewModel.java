package com.seymasingin.contactsretrofit.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.seymasingin.contactsretrofit.data.repo.ContactsRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AddViewModel extends ViewModel {
    private ContactsRepository crepo;

    @Inject
    public AddViewModel(ContactsRepository crepo){
        this.crepo = crepo;
    }

    public void add(String etName, String etTel) {
        crepo.add(etName,etTel);
    }
}
