package irawan.electroshock.beritaku.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Article(
    @SerializedName("author")
    val author: String? = "N/A" ?: "None",

    @SerializedName("content")
    val content: String? = "N/A" ?: "None",

    @SerializedName("description")
    val description: String? = "N/A" ?: "None",

    @SerializedName("publishedAt")
    val publishedAt: String? = "N/A" ?: "None",

    @SerializedName("source")
    val source: Source?,

    @SerializedName("title")
    val title: String? = "N/A" ?: "None",

    @SerializedName("url")
    val url: String? = "N/A" ?: "None",

    @SerializedName("urlToImage")
    val urlToImage: String? = "N/A" ?: "None"
):Serializable