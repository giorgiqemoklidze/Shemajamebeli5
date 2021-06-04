package com.example.shemajamebeli5


import android.content.ClipData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli5.databinding.FirstRecyclerViewBinding
import com.example.shemajamebeli5.databinding.MainFragmentBinding


class MainFragment : Fragment() {

    private lateinit var binding : MainFragmentBinding

    private lateinit var bindingInner : FirstRecyclerViewBinding

    private lateinit var viewModel: MainViewModel

    private lateinit var  adapter : FirstRecylerAdapter

    private lateinit var  adapterInner : RecycerItemsRecyclerAdapter

    private var cardViewNumber = 2
   private lateinit var items : List<ItemsModel>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingInner = FirstRecyclerViewBinding.inflate(layoutInflater,container,false)
        binding = MainFragmentBinding.inflate(layoutInflater,container,false)
        init()
        return binding.root
    }


    fun init(){
        initRecyclerFirst()
        observes()
    }


    fun initRecyclerFirst(){

        adapter = FirstRecylerAdapter()
        binding.FirstRecycler.layoutManager = LinearLayoutManager(requireActivity())
        binding.FirstRecycler.adapter = adapter


    }




    private fun observes(){
        viewModel._itemsLiveData.observe(viewLifecycleOwner, Observer {
            adapter.getItems(it.size)
            for (i in 0.. it.size){
                items = it[i]
            }
            adapterInner.setData(items.toMutableList())

        })



    }






}