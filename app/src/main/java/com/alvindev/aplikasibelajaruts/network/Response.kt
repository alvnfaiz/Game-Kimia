package com.alvindev.aplikasibelajaruts.network

import com.squareup.moshi.Json

/**
 * This data class defines a Response from JSON.
 * The property names of this data class are used by Moshi to match the names of values in JSON.
 */
data class Response(
    @Json(name = "hasil")
    val hasil: Hasil? = null
)

data class Hasil(

    @Json(name = "unsur")
    val unsur: String? = null,

    @Json(name = "lambang")
    val lambang: String? = null
)
