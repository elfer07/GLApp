package ar.com.glapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ar.com.glapp.repository.MainRepository

/**
 * Created by Fernando Moreno on 22/4/2021.
 */
class MainViewModelFactory(private val repository: MainRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MainRepository::class.java).newInstance(repository)
    }
}