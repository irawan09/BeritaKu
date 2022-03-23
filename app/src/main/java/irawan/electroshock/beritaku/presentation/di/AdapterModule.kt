package irawan.electroshock.beritaku.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import irawan.electroshock.beritaku.presentation.adapter.NewsAdapter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {

    @Provides
    @Singleton
    fun provideNewsAdapter(): NewsAdapter {
        return NewsAdapter()
    }
}