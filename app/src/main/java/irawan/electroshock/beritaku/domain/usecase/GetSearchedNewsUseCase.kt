package irawan.electroshock.beritaku.domain.usecase

import irawan.electroshock.beritaku.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
}