package com.voyagerss.financial.dto;

import com.google.gson.annotations.SerializedName;
import com.voyagerss.financial.domain.KrBankSchema;
import lombok.Data;

import java.util.List;

@Data
public class KrBankSchemaResponse {

    @SerializedName("StatisticSearch")
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

