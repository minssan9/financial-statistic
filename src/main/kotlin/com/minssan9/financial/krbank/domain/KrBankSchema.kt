package com.minssan9.financial.krbank.domain

import com.google.gson.annotations.SerializedName
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@Table(name = "krbankschema")
data class KrBankSchema(
        @Column(name = "id")
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id : Int,

        @Column(name = "CYCLE")     @SerializedName("CYCLE")            val cycle: String,
        @Column(name = "ORG_NAME")  @SerializedName("ORG_NAME")         val orgname: String,
        @Column(name = "P_STAT_CODE")   @SerializedName("P_STAT_CODE")  val pstatcode: String, // *
        @Column(name = "SRCH_YN")   @SerializedName("SRCH_YN")          val srchyn: String, // N
        @Column(name = "STAT_CODE")     @SerializedName("STAT_CODE")    val statcode: String, // 000Y005
        @Column(name = "STAT_NAME")     @SerializedName("STAT_NAME")    val statname: String // 1.통화 및 유동성지표

)
