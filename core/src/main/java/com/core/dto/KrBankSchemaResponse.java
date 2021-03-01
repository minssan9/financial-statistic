package com.core.dto;

import com.core.domain.EcosSchema;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class KrBankSchemaResponse {

    @SerializedName("StatisticTableList")
    private StatisticTableList statisticTableList;

    @Data
    public class StatisticTableList {
        @SerializedName("list_total_count")
        int list_total_count;
        @SerializedName("row")
        List<EcosSchema> row;

        public List<EcosSchema> getKrBankSchema() {
            return row;
        }
    }
}

