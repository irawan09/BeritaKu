package irawan.electroshock.beritaku.data.repository.dataSourceImpl

import irawan.electroshock.beritaku.data.db.ArticleDAO
import irawan.electroshock.beritaku.data.model.APIResponse
import irawan.electroshock.beritaku.data.model.Article
import irawan.electroshock.beritaku.data.repository.dataSource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsLocalDataSourceImpl(private val articleDAO: ArticleDAO): NewsLocalDataSource {
    override suspend fun saveArticleToDB(article: Article){
      articleDAO.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDAO.getAllArticles()
    }
}