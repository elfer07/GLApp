package ar.com.glapp.ui.laptop.adapter

import ar.com.glapp.data.model.Laptop

/**
 * Created by Fernando Moreno on 22/4/2021.
 */
interface OnLaptopClickListener {
    fun onLaptopClick(laptop: Laptop, position: Int)
}