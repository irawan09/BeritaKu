package irawan.electroshock.beritaku.domain.repository

import irawan.electroshock.beritaku.data.model.APIResponse
import irawan.electroshock.beritaku.data.model.Article
import irawan.electroshock.beritaku.data.util.Resource

interface NewsRepository {

    suspend fun getNewsHeadlines(): Resource<APIResponse>
    suspend fun getSearchedNews(stringQuery:String): Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
}