package ar.com.glapp.repository

import ar.com.glapp.data.model.Laptop

/**
 * Created by Fernando Moreno on 22/4/2021.
 */
interface MainRepository {
    suspend fun getLaptops(): List<Laptop>
}