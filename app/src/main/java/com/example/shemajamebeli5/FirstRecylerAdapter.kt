package com.example.shemajamebeli5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli5.databinding.FirstRecyclerViewBinding

class FirstRecylerAdapter():RecyclerView.Adapter<FirstRecylerAdapter.ViewHolder>() {

    var cardViewNumber = 0

    inner class ViewHolder(private val binding: FirstRecyclerViewBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(){

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