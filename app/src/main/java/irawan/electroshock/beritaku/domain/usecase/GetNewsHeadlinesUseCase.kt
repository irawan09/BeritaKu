package irawan.electroshock.beritaku.domain.usecase

import irawan.electroshock.beritaku.data.model.APIResponse
import irawan.electroshock.beritaku.data.util.Resource
import irawan.electroshock.beritaku.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, page: Int): Resource<APIResponse>{
        return newsRepository.getNewsHeadlines(country, page)
    }
}