package com.seymasingin.contactsretrofit.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.seymasingin.contactsretrofit.data.repo.ContactsRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DetailViewModel extends ViewModel {

    private ContactsRepository crepo;

    @Inject
    public DetailViewModel(ContactsRepository crepo){
        this.crepo = crepo;
    }

    public void refresh(int person_id, String person_name, String person_tel) {
        crepo.refresh(person_id, person_name,person_tel);
    }
}
