package com.core.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;

@Data
public class EcosResponse {

    @SerializedName("StatisticTableList")
    private StatisticTableList statisticTableList;

    @Data
    public class StatisticTableList {
        @SerializedName("list_total_count")
        int list_total_count;
        @SerializedName("row")
        List<Object> row;

//        public List<EcosSchema> getKrBankSchema() {
//            return row.stream().map(i-> {
//                return new EcosSchema(i)
//            }).collect(Collectors.toList());
//        }
    }
}

