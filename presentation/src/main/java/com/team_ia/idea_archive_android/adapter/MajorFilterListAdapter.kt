package com.team_ia.idea_archive_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.team_ia.idea_archive_android.databinding.ItemMajorFilterBinding

class MajorFilterListAdapter(private val majorFilterList: List<String>?) : RecyclerView.Adapter<MajorFilterListAdapter.MajorFilterViewHolder>() {
    class MajorFilterViewHolder(val binding: ItemMajorFilterBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: List<String>?, position: Int){
            binding.btnMajorFilter.text = data?.get(position).toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MajorFilterViewHolder {
        val binding = ItemMajorFilterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MajorFilterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return majorFilterList?.size ?: 0
    }

    override fun onBindViewHolder(holder: MajorFilterViewHolder, position: Int) {
        holder.bind(majorFilterList, position)
    }

}