package irawan.electroshock.beritaku.domain.usecase

import irawan.electroshock.beritaku.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
}