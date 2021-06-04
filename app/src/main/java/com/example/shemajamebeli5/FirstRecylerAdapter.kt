package com.example.shemajamebeli5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli5.databinding.FirstRecyclerViewBinding

class FirstRecylerAdapter():RecyclerView.Adapter<FirstRecylerAdapter.ViewHolder>() {

    var cardViewNumber = 1
    inner class ViewHolder(private val binding: FirstRecyclerViewBinding): RecyclerView.ViewHolder(binding.root){

        private lateinit var  adapter : RecycerItemsRecyclerAdapter

        fun bind(){
            adapter = RecycerItemsRecyclerAdapter()
            binding.InnerRecycler.layoutManager = LinearLayoutManager(binding.root.context)
            binding.InnerRecycler.adapter = adapter

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(FirstRecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = cardViewNumber


    fun getItems(cardViewNumberr:Int){
        cardViewNumber=cardViewNumberr
    }
}