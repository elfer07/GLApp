package ar.com.glapp.presentation

import androidx.lifecycle.*
import ar.com.glapp.core.Resource
import ar.com.glapp.repository.MainRepository
import kotlinx.coroutines.Dispatchers

/**
 * Created by Fernando Moreno on 22/4/2021.
 */
class MainViewModel(private val repository: MainRepository): ViewModel() {

    fun fetchMainLaptops() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.getLaptops()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}