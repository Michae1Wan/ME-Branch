package com.michae1.codechallenge.data.model

import com.google.gson.annotations.SerializedName

data class EmployeeModel  (
    @SerializedName("birth_date") val birth_date: String,
    @SerializedName("first_name") val first_name: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("last_name") val last_name: String,
    @SerializedName("thumbImage") val thumbImage: String
)