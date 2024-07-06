package com.example.music.retrofit;


import com.example.music.entity.ResponseBody;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("music/homePage")
    Call<ResponseBody> search(@Query("current") int current, @Query("size") int size);

}
