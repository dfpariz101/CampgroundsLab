package com.codepath.campgrounds

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Top-level API response: { "total": ..., "limit": ..., "start": ..., "data": [ ... ] }
@Keep
@Serializable
data class CampgroundResponse(
    @SerialName("data")
    val data: List<Campground>?
)

// One campground inside the "data" array
@Keep
@Serializable
data class Campground(
    @SerialName("name")
    val name: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("latLong")
    val latLong: String?,
    @SerialName("images")
    val images: List<CampgroundImage>?
) : java.io.Serializable {
    // Convenience property to easily get the first image URL if it exists
    val imageUrl: String
        get() = images?.firstOrNull { !it.url.isNullOrEmpty() }?.url ?: ""
}

// One image inside a campground's "images" array.
// Must also be java.io.Serializable so the whole Campground can be passed in an Intent.
@Keep
@Serializable
data class CampgroundImage(
    @SerialName("url")
    val url: String?,
    @SerialName("title")
    val title: String?
) : java.io.Serializable
