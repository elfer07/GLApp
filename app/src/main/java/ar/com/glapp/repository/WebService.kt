package ar.com.glapp.repository

import ar.com.glapp.data.model.Laptop
import retrofit2.http.GET

/**
 * Created by Fernando Moreno on 22/4/2021.
 */
interface WebService {

    @GET("list")
    suspend fun getLaptops(): List<Laptop>
}