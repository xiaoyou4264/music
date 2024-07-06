package com.example.music.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
  // 定义一个静态常量，用于存储访问的网址
   private static final String BASE_URL = "https://hotfix-service-prod.g.mi.com/";
  private static Retrofit retrofit = null;

  /**
   * 定义一个获取Retrofit实例的方法
   * Retrofit实例可以通过.create()方法，生成一个ApiService实例
   * 其实可以把BASE_URL作为参数传进去，这样比较灵活
  */
  public static Retrofit getClient() {
      if (retrofit == null) {
          retrofit = new Retrofit.Builder()
                  .baseUrl(BASE_URL)
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();
      }
      return retrofit;
  }
  
  /**
   * 获取ApiService实例
   */
  public static ApiService getApiService() {
        return getClient().create(ApiService.class);
  }
}