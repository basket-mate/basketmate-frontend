package com.example.basketmate

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuRVAdapter(val items : MutableList<String>) : RecyclerView.Adapter<MenuRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuRVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuRVAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item : String) {
            val rv_text = itemView.findViewById<TextView>(R.id.menu_rv_Text)
            rv_text.text = item
        }
    }
}