package com.core.dto;

import com.core.domain.EcosSchema;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;

@Data
public class EcosSchemaResponse {

    @SerializedName("StatisticTableList")
    private StatisticTableList statisticTableList;

    @Data
    public class StatisticTableList {
        @SerializedName("list_total_count")
        int list_total_count;
        @SerializedName("row")
        List<EcosSchema> row;
    }
}

