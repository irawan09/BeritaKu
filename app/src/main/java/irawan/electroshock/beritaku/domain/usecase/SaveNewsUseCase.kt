package irawan.electroshock.beritaku.domain.usecase

import irawan.electroshock.beritaku.data.model.Article
import irawan.electroshock.beritaku.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article)= newsRepository.saveNews(article)
}