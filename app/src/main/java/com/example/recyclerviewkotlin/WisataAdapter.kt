package com.example.recyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_wisata.view.*

class WisataAdapter(private var datalist: ArrayList<Wisata>?) :
    RecyclerView.Adapter<WisataAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_wisata,parent,false))
    }

    override fun getItemCount(): Int {
        return datalist?.size!!
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.nama.text = datalist?.get(position)!!.nama
        holder.desc.text = datalist?.get(position)!!.desc
        Glide.with(holder.itemView)
            .load(datalist?.get(position)!!.photo)
            .apply(RequestOptions.overrideOf(120,120))
            .error(R.drawable.ic_launcher_background)
            .into(holder.photo)
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nama = itemView.tvJudul
        var desc = itemView.tvDesc
        var photo = itemView.imgWisata
    }
}