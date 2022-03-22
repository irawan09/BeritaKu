package irawan.electroshock.beritaku.data.repository.dataSource

import irawan.electroshock.beritaku.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTheTopHeadlines(country: String, page: Int): Response<APIResponse>
}