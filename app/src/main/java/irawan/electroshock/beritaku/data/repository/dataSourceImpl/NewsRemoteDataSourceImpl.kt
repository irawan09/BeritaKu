package irawan.electroshock.beritaku.data.repository.dataSourceImpl

import irawan.electroshock.beritaku.data.api.NewsAPIService
import irawan.electroshock.beritaku.data.model.APIResponse
import irawan.electroshock.beritaku.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService
): NewsRemoteDataSource {
    override suspend fun getTheTopHeadlines(country:String, page:Int): Response<APIResponse> {
        return newsAPIService.getTheTopHeadlines(country, page)
    }
}