package com.example.depiproject.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.depiproject.databinding.ViewholderTopDoctorBinding

class TopDoctorAdapter(val items: MutableList<DoctorsModel>):RecyclerView.Adapter<TopDoctorAdapter.Viewholder>() {
    private var context: Context?=null

    class Viewholder(val binding: ViewholderTopDoctorBinding ):RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
    context=parent.context
        val binding =
            ViewholderTopDoctorBinding.inflate(LayoutInflater.from(context), parent , false)
        return Viewholder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.binding.nameTxt.text = items[position].Name
        holder.binding.specialTxt.text = items[position].Special
        holder.binding.scoreTxt.text = items[position].Rating.toString()
        holder.binding.yearTxt.text = items[position].Experience.toString() + " Years"

        Glide.with(holder.itemView.context)
            .load(items[position].Picture)
            .apply{ RequestOptions().transform(CenterCrop())}
            .into(holder.binding.img)
    }
}