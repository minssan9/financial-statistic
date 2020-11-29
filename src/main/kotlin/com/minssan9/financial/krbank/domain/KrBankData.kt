package com.minssan9.financial.krbank.domain

import com.google.gson.annotations.SerializedName
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "krbankdata")
data class KrBankData(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id : Int? = null,

        @SerializedName("UNIT_NAME") val unit_name : String,
        @SerializedName("STAT_NAME") val stat_name : String,
        @SerializedName("ITEM_CODE1") val item_code1 : String,
        @SerializedName("STAT_CODE") val stat_code : String,
        @SerializedName("ITEM_CODE2") val item_code2 : String,
        @SerializedName("ITEM_CODE3") val item_code3 : String,
        @SerializedName("ITEM_NAME1") val item_name1 : String,
        @SerializedName("ITEM_NAME2") val item_name2 : String,
        @SerializedName("DATA_VALUE") val data_value : Double,
        @SerializedName("ITEM_NAME3") val item_name3 : String,
        @SerializedName("TIME") val time : String
)

//@Entity
//data class StatisticSearchRow(
//        @Id @GeneratedValue
//        val id : Long,
//
//        @SerializedName("UNIT_NAME") val unit_name : String,
//        @SerializedName("STAT_NAME") val stat_name : String,
//        @SerializedName("ITEM_CODE1") val item_code1 : String,
//        @SerializedName("STAT_CODE") val stat_code : String,
//        @SerializedName("ITEM_CODE2") val item_code2 : String,
//        @SerializedName("ITEM_CODE3") val item_code3 : String,
//        @SerializedName("ITEM_NAME1") val item_name1 : String,
//        @SerializedName("ITEM_NAME2") val item_name2 : String,
//        @SerializedName("DATA_VALUE") val data_value : Double,
//        @SerializedName("ITEM_NAME3") val item_name3 : String,
//        @SerializedName("TIME") val time : String
//)
