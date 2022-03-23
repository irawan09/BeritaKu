package irawan.electroshock.beritaku.data.model

import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("articles")
    val articles: List<Article>,

    @SerializedName("status")
    val status: String? = "N/A" ?: "None",

    @SerializedName("totalResults")
    val totalResults: Int? = 0 ?: 0
)