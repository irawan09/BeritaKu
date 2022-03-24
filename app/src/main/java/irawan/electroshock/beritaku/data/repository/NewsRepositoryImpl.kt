package irawan.electroshock.beritaku.data.repository

import irawan.electroshock.beritaku.data.model.APIResponse
import irawan.electroshock.beritaku.data.model.Article
import irawan.electroshock.beritaku.data.repository.dataSource.NewsLocalDataSource
import irawan.electroshock.beritaku.data.repository.dataSource.NewsRemoteDataSource
import irawan.electroshock.beritaku.data.util.Resource
import irawan.electroshock.beritaku.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource : NewsRemoteDataSource,
    private val newsLocalDataSource : NewsLocalDataSource
): NewsRepository {
    override suspend fun getNewsHeadlines(country:String, page:Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTheTopHeadlines(country, page))
    }

    override suspend fun getSearchedNews(
        country: String,
        stringQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getSearchedNews(country, stringQuery, page))
    }

    private fun responseToResource(response: Response<APIResponse>):Resource<APIResponse>{
        if(response.isSuccessful){
            response.body()?.let { result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun saveNews(article: Article) {
       newsLocalDataSource.saveArticleToDB(article)
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return newsLocalDataSource.getSavedArticles()
    }
}