package ar.com.glapp.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Fernando Moreno on 22/4/2021.
 */
abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}