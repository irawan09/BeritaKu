package irawan.electroshock.beritaku.presentation.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import irawan.electroshock.beritaku.BuildConfig
import irawan.electroshock.beritaku.data.api.NewsAPIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun providedNewsAPIService(retrofit: Retrofit): NewsAPIService{
        return retrofit.create(NewsAPIService::class.java)
    }
}