package com.example.lab_week_06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel

class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<CatViewHolder>() {

    // Mutable List for storing all the list data [cite: 289]
    private val cats = mutableListOf<CatModel>()

    // A function to set the mutable List [cite: 290]
    fun setData(newCats: List<CatModel>) {
        cats.clear() // [cite: 292]
        cats.addAll(newCats) // [cite: 293]
        // This is used to tell the adapter that there's a data change [cite: 294]
        notifyDataSetChanged() // [cite: 296]
    }

    // onCreateViewHolder is instantiating the view holder it self [cite: 298]
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false) // [cite: 300]
        return CatViewHolder(view, imageLoader) // [cite: 300]
    }

    // This is used to bind each data to each Layout views [cite: 302]
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        // The holder.bindData function is declared in the CatViewHolder [cite: 303]
        holder.bindData(cats[position]) // [cite: 306]
    }

    // This is used to get the amount of data/item in the list [cite: 301]
    override fun getItemCount() = cats.size
}