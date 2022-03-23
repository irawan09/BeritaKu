package irawan.electroshock.beritaku.data.model

import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    val id: String? = "N/A" ?: "None",

    @SerializedName("name")
    val name: String? = "N/A" ?: "None"
)