package irawan.electroshock.beritaku.domain.usecase

import irawan.electroshock.beritaku.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
}