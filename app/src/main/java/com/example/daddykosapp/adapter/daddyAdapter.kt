package com.example.daddykosapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daddykosapp.R
import com.example.daddykosapp.model.DataItem
import kotlinx.android.synthetic.main.item_blog.view.*

class daddyAdapter(private val list: ArrayList<DataItem>): RecyclerView.Adapter<daddyAdapter.daddyViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): daddyViewHolder {
        return daddyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_blog,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: daddyViewHolder, position: Int) {
        holder.bindModel(list[position])

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(list[holder.adapterPosition])}
    }


    inner class daddyViewHolder (itemView : View): RecyclerView.ViewHolder(itemView){
        fun bindModel(dataItem: DataItem){
            with(itemView){
                tv_namakos.text = dataItem.namakos
                tv_alamat.text = dataItem.alamat
                tv_fasilitaas.text = dataItem.fasilitas
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataItem)
    }


}