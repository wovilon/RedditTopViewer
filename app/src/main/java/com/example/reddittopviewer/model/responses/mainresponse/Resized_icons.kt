import com.google.gson.annotations.SerializedName

data class Resized_icons (

	@SerializedName("url") val url : String,
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int
)