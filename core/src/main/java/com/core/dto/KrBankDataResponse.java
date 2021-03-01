package com.core.dto;

import com.core.domain.EcosData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class KrBankDataResponse implements Serializable {

    @SerializedName("StatisticSearch")
    @Expose
    public StatisticSearch statisticSearch;

    @Data
    public class StatisticSearch implements Serializable {

        @SerializedName("list_total_count")
        @Expose
        public int listTotalCount;
        @SerializedName("row")
        @Expose
        public List<EcosData> row = null;
    }
}

