package irawan.electroshock.beritaku.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NewsAPIServiceTest {

    private lateinit var service: NewsAPIService
    private lateinit var server:MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    private fun enqueueMockResponse(filename: String){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(filename)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTheTopHeadlines_sentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTheTopHeadlines("us",1).body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=82e907de3c9d4a7aa2aeeb5c678f24b3")
        }
    }

    @Test
    fun getTheTopHeadlines_receivedResponse_correctPageSize(){
        runBlocking{
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTheTopHeadlines("us", 1).body()
            val articlesList = responseBody!!.articles
            assertThat(articlesList.size).isEqualTo(20)
        }
    }

    @Test
    fun getTheTopHeadlines_receivedResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTheTopHeadlines("us", 1).body()
            val articlesList = responseBody!!.articles
            val article = articlesList[0]
            assertThat(article.author).isEqualTo("Rebecca English, Jessica Green, Kaya Terry")
            assertThat(article.title).isEqualTo("Duchess of Cambridge swaps khaki jungle gear for Vampire's Wife dress on Belize trip - Daily Mail")
            assertThat(article.content).isEqualTo("The Duchess of Cambridge swapped her khaki jungle outfit for a floor-length shimmering gown by royal favourite designer The Vampire's Wife on the third day of her Belize trip with her husband Prince … [+9326 chars]")
            assertThat(article.description).isEqualTo("Kate, 40, dressed in the  £2,500 pink gown by the British designer for an evening reception in celebration of Her Majesty The Queen's Platinum Jubilee.")
            assertThat(article.publishedAt).isEqualTo("2022-03-22T08:21:32Z")
            assertThat(article.url).isEqualTo("https://www.dailymail.co.uk/femail/article-10637327/Casual-Kate-Middleton-sports-70-khaki-trousers-visit-Mayan-ruins-Belize-jungle.html")
            assertThat(article.urlToImage).isEqualTo("https://i.dailymail.co.uk/1s/2022/03/22/02/55637269-0-image-a-6_1647915783900.jpg")
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}