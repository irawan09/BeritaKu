package irawan.electroshock.beritaku.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import irawan.electroshock.beritaku.data.repository.NewsRepositoryImpl
import irawan.electroshock.beritaku.data.repository.dataSource.NewsLocalDataSource
import irawan.electroshock.beritaku.data.repository.dataSource.NewsRemoteDataSource
import irawan.electroshock.beritaku.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import irawan.electroshock.beritaku.domain.repository.NewsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(
            newsRemoteDataSource,
            newsLocalDataSource)
    }
}