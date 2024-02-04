package com.seymasingin.contactsretrofit.retrofit;

import com.seymasingin.contactsretrofit.data.model.CRUDResponse;
import com.seymasingin.contactsretrofit.data.model.PersonResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ContactsDao {

    @GET("kisiler/tum_kisiler.php")
    Call<PersonResponse> allContacts();

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    Call<PersonResponse> searchContact(@Field("kisi_ad") String person_name);

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    Call<CRUDResponse> deleteContact(@Field("kisi_id") int person_id);

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    Call<CRUDResponse> addContact(@Field("kisi_ad") String person_name,
                                  @Field("kisi_tel") String person_tel);

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    Call<CRUDResponse> updateContact(@Field("kisi_id") int person_id,
                                     @Field("kisi_ad") String person_name,
                                     @Field("kisi_tel") String person_tel);
}
