package com.example.shemajamebeli5

import android.text.Editable
import android.text.TextWatcher
import android.util.Log.d
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli5.databinding.InnrerRecyclerViewBinding

class InnerRecyclerAdapter(var items: MutableList<ItemsModel>):RecyclerView.Adapter<InnerRecyclerAdapter.ViewHolder>() {



    companion object{
        var savedValue = mutableMapOf<Int,String>()
    }


    inner class ViewHolder(private val binding: InnrerRecyclerViewBinding): RecyclerView.ViewHolder(
        binding.root
    ){
        private lateinit var model: ItemsModel



        fun bind(){
            model = items[adapterPosition]
            binding.EditText.hint = model.hint
            binding.EditText.tag = model.fieldId
            model.fieldId?.let { savedValue.put(it,"") }

           binding.EditText.addTextChangedListener(object : TextWatcher {
               override fun beforeTextChanged(
                   s: CharSequence?,
                   start: Int,
                   count: Int,
                   after: Int
               ) {

               }

               override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                   if (savedValue.containsKey(model.fieldId)){
                       savedValue.remove(model.fieldId)

                   model.fieldId?.let { savedValue.put(it,s.toString())
                       d("sas", "$savedValue")}
                  }else{

                       model.fieldId?.let { savedValue.put(it,s.toString())
                           d("sas", "$savedValue")}
                   }
               }

               override fun afterTextChanged(s: Editable?) {


               }

           })


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(
            InnrerRecyclerViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = items.size



}