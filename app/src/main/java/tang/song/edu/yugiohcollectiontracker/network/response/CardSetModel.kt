package tang.song.edu.yugiohcollectiontracker.network.response

import com.google.gson.annotations.SerializedName

data class CardSetModel(
    @SerializedName("set_name")
    val setName: String,
    @SerializedName("set_code")
    val setCode: String,
    @SerializedName("set_rarity")
    val setRarity: String,
    @SerializedName("set_price")
    val setPrice: String
)
