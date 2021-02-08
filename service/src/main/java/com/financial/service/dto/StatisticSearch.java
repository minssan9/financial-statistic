package com.financial.service.dto;

import com.financial.service.domain.KrBankData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class StatisticSearch implements Serializable {

    @SerializedName("list_total_count")
    @Expose
    public int listTotalCount;
    @SerializedName("row")
    @Expose
    public List<KrBankData> row = null;
}
