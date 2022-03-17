package irawan.electroshock.beritaku.domain.usecase

import irawan.electroshock.beritaku.data.model.APIResponse
import irawan.electroshock.beritaku.data.model.Article
import irawan.electroshock.beritaku.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute():Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}