package com.example.covid_19.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid_19.databinding.ItemProvinceBinding
import com.example.covid_19.model.ProvinceResponse

class ProvinceAdapter(val context: Context, val data: ArrayList<ProvinceResponse>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private class MyViewHolder(val binding: ItemProvinceBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(ItemProvinceBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = data[position]

        if(holder is MyViewHolder) {
            holder.binding.tvProvinsi.text = model.attributes.nama
            holder.binding.tvProvincePositif.text = model.attributes.positif.toString()
            holder.binding.tvProvinceSembuh.text = model.attributes.sembuh.toString()
            holder.binding.tvProvinceMeninggal.text = model.attributes.meninggal.toString()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


}