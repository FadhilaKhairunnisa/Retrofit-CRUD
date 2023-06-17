package com.app.pertemuan10restApi.model.response


import com.app.pertemuan10restApi.model.request.DataDetailMahasiswa
import com.google.gson.annotations.SerializedName

data class ResponseDetailDataMahasiswa(
    @SerializedName("data")
    val data: DataDetailMahasiswa,
    @SerializedName("status")
    val status: String
)