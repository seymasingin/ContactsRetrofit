package com.seymasingin.contactsretrofit.di;

import com.seymasingin.contactsretrofit.data.repo.ContactsRepository;
import com.seymasingin.contactsretrofit.retrofit.ApiUtils;
import com.seymasingin.contactsretrofit.retrofit.ContactsDao;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Singleton
    @Provides
    public ContactsRepository provideContactsRepository(ContactsDao contactsDao) {
        return new ContactsRepository(contactsDao);
    }

    @Singleton
    @Provides
    public ContactsDao provideContactsDao() {
        return ApiUtils.getContactDao();
    }

}
