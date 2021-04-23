package ar.com.glapp.ui.laptopdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import ar.com.glapp.R
import ar.com.glapp.databinding.FragmentLaptopDetailBinding
import com.bumptech.glide.Glide

class LaptopDetailFragment : Fragment(R.layout.fragment_laptop_detail) {

    private lateinit var binding: FragmentLaptopDetailBinding

    private val args by navArgs<LaptopDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLaptopDetailBinding.bind(view)

        Glide.with(requireContext()).load(args.image).centerCrop().into(binding.ivLaptop)
        binding.tvTitleDetails.text = args.title
        binding.tvDescriptionDetails.text = args.description

    }
}