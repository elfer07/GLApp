package ar.com.glapp.ui.laptop

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.glapp.R
import ar.com.glapp.core.Resource
import ar.com.glapp.data.model.Laptop
import ar.com.glapp.data.remote.RemoteMainDataSource
import ar.com.glapp.databinding.FragmentLaptopBinding
import ar.com.glapp.presentation.MainViewModel
import ar.com.glapp.presentation.MainViewModelFactory
import ar.com.glapp.repository.MainRepositoryImpl
import ar.com.glapp.repository.RetrofitClient
import ar.com.glapp.ui.laptop.adapter.LaptopAdapter
import ar.com.glapp.ui.laptop.adapter.OnLaptopClickListener

class LaptopFragment : Fragment(R.layout.fragment_laptop), OnLaptopClickListener {

    private lateinit var binding: FragmentLaptopBinding

    private val viewModel by viewModels<MainViewModel> {
        MainViewModelFactory(MainRepositoryImpl(RemoteMainDataSource(RetrofitClient.webservice)))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLaptopBinding.bind(view)

        binding.rvLaptop.layoutManager = LinearLayoutManager(requireContext())

        viewModel.fetchMainLaptops().observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Loading -> {
                    Log.d("LIVE", "Loading...")
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("LIVE", "Success: ${it.data}")
                    binding.rvLaptop.adapter = LaptopAdapter(requireContext(), it.data, this)
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("ERROR", "ERROR: ${it.exception}")
                }
            }
        })
    }

    override fun onLaptopClick(laptop: Laptop, position: Int) {
        Log.d("LIVE", "Click on: ${laptop.title}")
        val send = LaptopFragmentDirections.actionLaptopFragmentToLaptopDetailFragment(
            laptop.title,
            laptop.description,
            laptop.image
        )
        findNavController().navigate(send)
    }
}