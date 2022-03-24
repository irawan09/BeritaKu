package irawan.electroshock.beritaku.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "table_news")
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id :Int? = null,

    @SerializedName("author")
    val author: String? = "N/A",

    @SerializedName("content")
    val content: String? = "N/A",

    @SerializedName("description")
    val description: String? = "N/A",

    @SerializedName("publishedAt")
    val publishedAt: String? = "N/A",

    @SerializedName("source")
    val source: Source?,

    @SerializedName("title")
    val title: String? = "N/A",

    @SerializedName("url")
    val url: String? = "N/A",

    @SerializedName("urlToImage")
    val urlToImage: String? = "N/A"
):Serializable