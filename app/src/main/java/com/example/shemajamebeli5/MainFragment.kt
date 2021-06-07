package com.example.shemajamebeli5


import android.content.ClipData
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli5.InnerRecyclerAdapter.Companion.savedValue

import com.example.shemajamebeli5.databinding.MainFragmentBinding


class MainFragment : Fragment() {


    private lateinit var binding: MainFragmentBinding


    private val viewModel: MainViewModel by viewModels()

    private lateinit var adapter: FirstRecylerAdapter

    private var container = mutableListOf<ItemsModel>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater, container, false)
        init()
        return binding.root
    }


    fun init() {
        viewModel.init()
        initRecyclerFirst()
        observes()
        RegisterBtnListener()
    }


    fun initRecyclerFirst() {

        adapter = FirstRecylerAdapter()
        binding.FirstRecycler.layoutManager = LinearLayoutManager(requireActivity())
        binding.FirstRecycler.adapter = adapter


    }


    private fun observes() {
        viewModel._itemsLiveData.observe(viewLifecycleOwner, Observer { list ->
            adapter.getItems(list)
            list.forEach {
                it.forEach { it1->
                    container.add(it1)
                }
            }


        })


    }



    private fun RegisterBtnListener() {


        binding.RegisterBtn.setOnClickListener {
            container.forEach{
               if (savedValue.containsKey(it.fieldId)){
                   if (it.required == "false"){

                   }else{
                       if (savedValue[it.fieldId] == ""||savedValue[it.fieldId] == null){
                           Toast.makeText(context, "aucileblad sheavse ${it.hint}", Toast.LENGTH_SHORT).show()
                       }
                   }
               }
            }

        }

    }


}