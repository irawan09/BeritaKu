package irawan.electroshock.beritaku.domain.usecase

import irawan.electroshock.beritaku.data.model.APIResponse
import irawan.electroshock.beritaku.data.util.Resource
import irawan.electroshock.beritaku.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, stringQuery:String, page: Int): Resource<APIResponse>{
        return newsRepository.getSearchedNews(country, stringQuery, page)
    }
}