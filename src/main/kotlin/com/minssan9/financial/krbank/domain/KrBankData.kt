package com.minssan9.financial.krbank.domain

import com.google.gson.annotations.SerializedName
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "krbankdata")
data class KrBankData(
        @Column(name = "id")
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id : Int,

        @Column(name = "UNIT_NAME") @SerializedName("UNIT_NAME") val unit_name : String,
        @Column(name = "STAT_NAME") @SerializedName("STAT_NAME") val stat_name : String,
        @Column(name = "ITEM_CODE1") @SerializedName("ITEM_CODE1") val item_code1 : String,
        @Column(name = "STAT_CODE") @SerializedName("STAT_CODE") val stat_code : String,
        @Column(name = "ITEM_CODE2") @SerializedName("ITEM_CODE2") val item_code2 : String,
        @Column(name = "ITEM_CODE3") @SerializedName("ITEM_CODE3") val item_code3 : String,
        @Column(name = "ITEM_NAME1") @SerializedName("ITEM_NAME1") val item_name1 : String,
        @Column(name = "ITEM_NAME2") @SerializedName("ITEM_NAME2") val item_name2 : String,
        @Column(name = "DATA_VALUE") @SerializedName("DATA_VALUE") val data_value : Double,
        @Column(name = "ITEM_NAME3") @SerializedName("ITEM_NAME3") val item_name3 : String,
        @Column(name = "TIME") @SerializedName("TIME") val time : String

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
