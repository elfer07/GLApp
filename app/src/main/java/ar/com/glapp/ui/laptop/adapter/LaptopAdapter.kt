package ar.com.glapp.ui.laptop.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ar.com.glapp.core.BaseViewHolder
import ar.com.glapp.data.model.Laptop
import ar.com.glapp.databinding.LaptopItemBinding
import com.bumptech.glide.Glide

/**
 * Created by Fernando Moreno on 22/4/2021.
 */
class LaptopAdapter(
    private val context: Context,
    private val laptopList: List<Laptop>,
    private val itemClickListener: OnLaptopClickListener
): RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = LaptopItemBinding.inflate(LayoutInflater.from(context), parent, false)
        val holder = LaptopViewHolder(itemBinding)

        itemBinding.root.setOnClickListener {
            val position = holder.bindingAdapterPosition.takeIf {
                it != DiffUtil.DiffResult.NO_POSITION} ?: return@setOnClickListener
            itemClickListener.onLaptopClick(laptopList[position], position)
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is LaptopViewHolder -> holder.bind(laptopList[position])
        }
    }

    override fun getItemCount(): Int = laptopList.size

    private inner class LaptopViewHolder(val binding: LaptopItemBinding): BaseViewHolder<Laptop>(binding.root){
        override fun bind(item: Laptop) {
            Glide.with(context).load(item.image).centerCrop().into(binding.ivLaptop)
            binding.tvTitle.text = item.title
            binding.tvDescription.text = item.description
        }
    }
}
