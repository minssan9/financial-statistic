package com.core.dto;

import com.core.domain.KrBankSchema;
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
        List<KrBankSchema> row;

        public List<KrBankSchema> getKrBankSchema() {
            return row;
        }
    }
}

