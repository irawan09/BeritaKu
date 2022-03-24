package irawan.electroshock.beritaku.data.repository.dataSource

import irawan.electroshock.beritaku.data.model.Article


interface NewsLocalDataSource {
    suspend fun saveArticleToDB(article: Article)
}