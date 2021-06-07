package com.example.shemajamebeli5

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val itemsLiveData = MutableLiveData<List<List<ItemsModel>>>().apply {
        mutableListOf<List<ItemsModel>>()
    }


    val _itemsLiveData : MutableLiveData<List<List<ItemsModel>>> = itemsLiveData

    fun init(){
        CoroutineScope(Dispatchers.IO).launch {

            getItems()
        }
    }

    private suspend fun  getItems(){

        val itemsList = RetrofitService.RetrofitService().getList()
        d("itemList","${itemsList.body()}")
        if (itemsList.isSuccessful){
            val items = itemsList.body()
            itemsLiveData.postValue(items)
        }else {
            itemsList.code()
        }




    }

}