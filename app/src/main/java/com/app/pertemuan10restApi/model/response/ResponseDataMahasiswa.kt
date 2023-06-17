package com.app.pertemuan10restApi.model.response


import com.app.pertemuan10restApi.model.request.DataAllMahasiswa
import com.google.gson.annotations.SerializedName

data class ResponseDataMahasiswa(
    @SerializedName("data")
    val data: List<DataAllMahasiswa>,
    @SerializedName("status")
    val status: String
)