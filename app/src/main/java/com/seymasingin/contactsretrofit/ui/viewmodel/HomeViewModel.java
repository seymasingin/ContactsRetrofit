package com.seymasingin.contactsretrofit.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.seymasingin.contactsretrofit.data.model.Person;
import com.seymasingin.contactsretrofit.data.repo.ContactsRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    private ContactsRepository crepo;

    public MutableLiveData<List<Person>> personList = new MutableLiveData();

    @Inject
    public HomeViewModel(ContactsRepository crepo) {
        this.crepo = crepo;
        getContacts();
        personList= crepo.getPersonList();
    }

    public void search(String word){
        crepo.search(word);
    }

    public void delete(int person_id){

        crepo.delete(person_id);
    }

    public void getContacts() {
        crepo.getContacts();
    }
}
