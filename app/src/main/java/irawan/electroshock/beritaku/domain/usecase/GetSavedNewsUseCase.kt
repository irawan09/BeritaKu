package irawan.electroshock.beritaku.domain.usecase

import irawan.electroshock.beritaku.domain.repository.NewsRepository

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
}