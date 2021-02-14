package com.service.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Document
@Data
public class EcosSchemaMongo {
        @Id @GeneratedValue
        ObjectId _id;

        private  String pstatcode; // 상위 통계표 코드
        private  String statcode; // 000Y005             	통계표코드
        private  String statname; // 1.통화 및 유동성지표
        private   String cycle;    //        주기
        private  String orgname;         // 출처
        private  String srchyn; // N

//        상위통계표코드	P_STAT_CODE	8	000Y074	상위통계표코드
//        통계표코드	STAT_CODE	8	000Y702
//        통계명	STAT_NAME	200	1.2.2 본원통화 구성내역(평잔)	통계명
//        주기	CYCLE	2	YY, QQ, MM, DD	주기(년, 분기, 월, 일)
//        검색가능여부	SRCH_YN	1	Y/N	검색가능여부
//        출처	ORG_NAME	50	국제통화기금(IMF)	출처
}
