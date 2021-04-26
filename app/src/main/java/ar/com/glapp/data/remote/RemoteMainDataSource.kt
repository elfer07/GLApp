package ar.com.glapp.data.remote

import ar.com.glapp.data.model.Laptop
import ar.com.glapp.repository.WebService

/**
 * Created by Fernando Moreno on 22/4/2021.
 */
class RemoteMainDataSource(private val webService: WebService) {

    suspend fun getLaptops(): List<Laptop> = webService.getLaptops()
}