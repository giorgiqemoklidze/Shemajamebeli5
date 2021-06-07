package com.example.shemajamebeli5

import com.google.gson.annotations.SerializedName

data class ItemsModel( @SerializedName("field_id")
                       val fieldId: Int?,
                       @SerializedName("field_type")
                       val fieldType: String?,
                       val hint: String?,
                       val icon: String?,
                       @SerializedName("is_active")
                       val isActive: Boolean?,
                       val keyboard: String?,
                       val required: String? ){
}