package com.seymasingin.contactsretrofit.retrofit;

public class ApiUtils {
    public static final String BASE_URL = "http://kasimadalan.pe.hu/";

    public static ContactsDao getContactDao() {
        return RetrofitClient.getClient(BASE_URL).create(ContactsDao.class);
    }

}
