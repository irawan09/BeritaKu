package irawan.electroshock.beritaku.presentation.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import irawan.electroshock.beritaku.domain.usecase.*
import irawan.electroshock.beritaku.presentation.viewmodel.NewsViewModelFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Provides
    @Singleton
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase : GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase : GetSearchedNewsUseCase,
        saveNewsUseCase : SaveNewsUseCase,
        getSavedNewsUseCase : GetSavedNewsUseCase,
        deleteSavedNewsUseCase : DeleteSavedNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(
            application,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSavedNewsUseCase,
            deleteSavedNewsUseCase
        )
    }

}