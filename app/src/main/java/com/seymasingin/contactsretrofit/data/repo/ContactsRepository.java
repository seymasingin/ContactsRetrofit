package com.seymasingin.contactsretrofit.data.repo;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.seymasingin.contactsretrofit.data.model.CRUDResponse;
import com.seymasingin.contactsretrofit.data.model.Person;
import com.seymasingin.contactsretrofit.data.model.PersonResponse;
import com.seymasingin.contactsretrofit.retrofit.ContactsDao;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactsRepository {

    private MutableLiveData<List<Person>> personList;
    private ContactsDao contactsDao;

    public ContactsRepository(ContactsDao contactsDao) {
        this.contactsDao = contactsDao;
        personList = new MutableLiveData();
    }

    public MutableLiveData<List<Person>> getPersonList(){
        return personList;
    }

    public void add(String person_name, String person_tel) {
        contactsDao.addContact(person_name, person_tel).enqueue(new Callback<CRUDResponse>() {
            @Override
            public void onResponse(Call<CRUDResponse> call, Response<CRUDResponse> response) {
                int success = response.body().getSuccess();
                String message = response.body().getMessage();
                Log.e("Add", success+" - "+message);
                getContacts();
            }

            @Override
            public void onFailure(Call<CRUDResponse> call, Throwable t) {}
        });
    }

    public void refresh(int person_id, String person_name, String person_tel) {
        contactsDao.updateContact(person_id, person_name, person_tel).enqueue(new Callback<CRUDResponse>() {
            @Override
            public void onResponse(Call<CRUDResponse> call, Response<CRUDResponse> response) {
                int success = response.body().getSuccess();
                String message = response.body().getMessage();
                Log.e("Update", success+" - "+message);
                getContacts();
            }

            @Override
            public void onFailure(Call<CRUDResponse> call, Throwable t) {}
        });
    }

    public void search(String word){
        contactsDao.searchContact(word).enqueue(new Callback<PersonResponse>() {
            @Override
            public void onResponse(Call<PersonResponse> call, Response<PersonResponse> response) {
                List<Person> list = response.body().getKisiler();
                personList.setValue(list);
            }

            @Override
            public void onFailure(Call<PersonResponse> call, Throwable t) {}
        });
    }

    public void delete(int person_id){
        contactsDao.deleteContact(person_id).enqueue(new Callback<CRUDResponse>() {
            @Override
            public void onResponse(Call<CRUDResponse> call, Response<CRUDResponse> response) {
                int success = response.body().getSuccess();
                String message = response.body().getMessage();
                Log.e("Delete", success+" - "+message);
                getContacts();
            }

            @Override
            public void onFailure(Call<CRUDResponse> call, Throwable t) {}
        });
    }

    public void getContacts() {
        contactsDao.allContacts().enqueue(new Callback<PersonResponse>() {
            @Override
            public void onResponse(Call<PersonResponse> call, Response<PersonResponse> response) {
                List<Person> list = response.body().getKisiler();
                personList.setValue(list);
            }

            @Override
            public void onFailure(Call<PersonResponse> call, Throwable t) {}
        });
    }
}
