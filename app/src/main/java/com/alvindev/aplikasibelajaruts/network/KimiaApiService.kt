package com.alvindev.aplikasibelajaruts.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.akuari.my.id/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

/**
 * A public interface that exposes the [getUnsur] method
 */
interface KimiaApiService {

    @GET("games/tebakkimia")
    suspend fun getUnsur(): Response
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object KimiaApi {
    val retrofitService: KimiaApiService by lazy { retrofit.create(KimiaApiService::class.java) }
}
