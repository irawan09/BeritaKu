package irawan.electroshock.beritaku.domain.usecase

import irawan.electroshock.beritaku.data.model.Article
import irawan.electroshock.beritaku.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}