package irawan.electroshock.beritaku.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import irawan.electroshock.beritaku.data.db.ArticleDAO
import irawan.electroshock.beritaku.data.repository.dataSource.NewsLocalDataSource
import irawan.electroshock.beritaku.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Provides
    @Singleton
    fun provideLocalDataModule(articleDAO: ArticleDAO): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDAO)
    }
}