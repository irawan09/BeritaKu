package irawan.electroshock.beritaku.data.repository.dataSource

import irawan.electroshock.beritaku.data.model.Article
import kotlinx.coroutines.flow.Flow


interface NewsLocalDataSource {
    suspend fun saveArticleToDB(article: Article)
    fun getSavedArticles(): Flow<List<Article>>
    suspend fun deleteArticlesFromDB(article: Article)
}