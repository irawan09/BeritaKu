package irawan.electroshock.beritaku.data.repository.dataSourceImpl

import irawan.electroshock.beritaku.data.db.ArticleDAO
import irawan.electroshock.beritaku.data.model.APIResponse
import irawan.electroshock.beritaku.data.model.Article
import irawan.electroshock.beritaku.data.repository.dataSource.NewsLocalDataSource
import retrofit2.Response

class NewsLocalDataSourceImpl(private val articleDAO: ArticleDAO): NewsLocalDataSource {
    override suspend fun saveArticleToDB(article: Article){
      articleDAO.insert(article)
    }
}