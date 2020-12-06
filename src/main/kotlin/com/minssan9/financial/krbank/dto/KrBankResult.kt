package com.minssan9.financial.krbank.dto

import com.google.gson.annotations.SerializedName
import com.minssan9.financial.krbank.domain.KrBankData
import com.minssan9.financial.krbank.domain.KrBankSchema

class KrBankDataResult{

    data class KrBankDataResult(
        @SerializedName("StatisticSearch")
        val dataResult: DataResult
    )

    data class KrBankSchemaResult(
        @SerializedName("StatisticSearch")
        val dataResult: SchemaResult
    )
    data class DataResult(
        @SerializedName("list_total_count") val list_total_count: Int,
        @SerializedName("row") val row: List<KrBankData>
    )

    data class SchemaResult(
        @SerializedName("list_total_count") val list_total_count: Int,
        @SerializedName("row") val row: List<KrBankSchema>
    )
}
