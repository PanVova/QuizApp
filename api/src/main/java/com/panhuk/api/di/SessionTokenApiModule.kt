package com.panhuk.api.di

import android.content.Context
import com.panhuk.api.BuildConfig
import com.panhuk.api.SessionTokenApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
class SessionTokenApiModule {

  @Provides
  fun provideOkhttpClient(): OkHttpClient =
    OkHttpClient.Builder()
      .build()

  @Provides
  fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
      .baseUrl(BuildConfig.TRIVIA_BASE_URL)
      .client(okHttpClient)
      .build()

  @Provides
  fun provideSessionTokenApi(retrofit: Retrofit): SessionTokenApi =
    retrofit.create(SessionTokenApi::class.java)
}