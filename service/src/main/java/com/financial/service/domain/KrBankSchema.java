package com.voyagerss.financial.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "krbankschema")
@Data
public class KrBankSchema {
        @Column(name = "id")
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        @SerializedName("P_STAT_CODE") @Expose @Column(name = "P_STAT_CODE") String pstatcode; // 상위 통계표 코드
        @SerializedName("STAT_CODE") @Expose @Column(name = "STAT_CODE") String statcode; // 000Y005             	통계표코드
        @SerializedName("STAT_NAME") @Expose @Column(name = "STAT_NAME") String statname; // 1.통화 및 유동성지표
        @SerializedName("CYCLE") @Expose @Column(name = "CYCLE")  String cycle;    //        주기
        @SerializedName("ORG_NAME") @Expose @Column(name = "ORG_NAME") String orgname;         // 출처
        @SerializedName("SRCH_YN") @Expose @Column(name = "SRCH_YN") String srchyn; // N

//        상위통계표코드	P_STAT_CODE	8	000Y074	상위통계표코드
//        통계표코드	STAT_CODE	8	000Y702
//        통계명	STAT_NAME	200	1.2.2 본원통화 구성내역(평잔)	통계명
//        주기	CYCLE	2	YY, QQ, MM, DD	주기(년, 분기, 월, 일)
//        검색가능여부	SRCH_YN	1	Y/N	검색가능여부
//        출처	ORG_NAME	50	국제통화기금(IMF)	출처
}
