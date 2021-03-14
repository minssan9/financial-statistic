package com.core.dto;

import com.core.domain.EcosData;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;

@Data
public class EcosDataResponse {

    @SerializedName("StatisticTableList")
    private StatisticTableList statisticTableList;

    @Data
    public class StatisticTableList {
        @SerializedName("list_total_count")
        int list_total_count;
        @SerializedName("row")
        List<EcosData> row; // generic

//        public List<EcosSchema> getKrBankSchema() {
//            return row.stream().map(i-> {
//                return new EcosSchema(i)
//            }).collect(Collectors.toList());
//        }
    }
}

