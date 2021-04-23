package ar.com.glapp.repository

import ar.com.glapp.data.model.Laptop
import ar.com.glapp.data.remote.RemoteMainDataSource

/**
 * Created by Fernando Moreno on 22/4/2021.
 */
class MainRepositoryImpl(private val dataSourceRemote: RemoteMainDataSource): MainRepository {
    override suspend fun getLaptops(): List<Laptop> = dataSourceRemote.getLaptops()
}