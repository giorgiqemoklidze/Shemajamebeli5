package com.example.shemajamebeli5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli5.databinding.FirstRecyclerViewBinding

import com.example.shemajamebeli5.databinding.InnrerRecyclerViewBinding

class RecycerItemsRecyclerAdapter():RecyclerView.Adapter<RecycerItemsRecyclerAdapter.ViewHolder>() {


    private var items = mutableListOf<ItemsModel>()

    inner class ViewHolder(private val binding: InnrerRecyclerViewBinding): RecyclerView.ViewHolder(binding.root){
        private lateinit var model: ItemsModel
        fun bind(){

            model = items[adapterPosition]
            binding.EditText.hint = model.hint


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(InnrerRecyclerViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = items.size

    fun setData(items:MutableList<ItemsModel>){
        this.items.clear()
        this.items = items
        notifyDataSetChanged()

    }

}