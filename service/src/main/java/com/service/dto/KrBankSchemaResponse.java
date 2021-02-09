package com.service.dto;

import com.service.domain.KrBankSchema;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;

@Data
public class KrBankSchemaResponse {

    @SerializedName("StatisticTableList")
    private KrBankSchemaResult krBankSchemaResult;

    @Data
    public class KrBankSchemaResult {
        @SerializedName("list_total_count")
        int list_total_count;
        @SerializedName("row")
        List<KrBankSchema> row;

        public List<KrBankSchema> getKrBankSchema() {
            return row;
        }
    }
}

